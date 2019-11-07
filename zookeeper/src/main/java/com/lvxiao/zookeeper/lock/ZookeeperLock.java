package com.lvxiao.zookeeper.lock;

import lombok.extern.log4j.Log4j2;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/7 3:23 下午
 */
@Log4j2
public class ZookeeperLock {

    /**
     * 使用ZkClient实现分布式锁
     */
    private static class NormalLock {
        //锁目录
        private static final String BASE_PATH = "/disLock";
        private static final String SPLIT_FLAG = "_";
        private Integer sessionOut;
        private String zkHost;
        private ZooKeeper zooKeeper;
        //当前锁节点名称
        private String lockNode;
        //等待锁节点名称
        private String waitNode;
        private CountDownLatch countDownLatch;

        public NormalLock(Integer sessionOut, String zkHost) {
            this.sessionOut = sessionOut;
            this.zkHost = zkHost;
        }

        //ZKDisLock初始化
        public void init() throws KeeperException, InterruptedException, IOException {
            zooKeeper = new ZooKeeper(zkHost, sessionOut, watchedEvent -> {
            });
            //判断有无根目录，没有的话创建
            Stat stat = zooKeeper.exists(BASE_PATH, false);
            if (stat == null) {
                zooKeeper.create(BASE_PATH, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        }

        //加锁
        public void lock(String content) throws Exception {
            if (zooKeeper == null) {
                throw new Exception("zk未初始化");
            }
            try {
                //创建节点
                String itemName = zooKeeper.create(BASE_PATH + "/" + content + SPLIT_FLAG, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
                //判断节点是否是目录中同一个content的最小节点
                if (isLowestNode(content, itemName)) {
                    System.out.println("线程：" + Thread.currentThread().getId() + ",加锁成功,节点名称：" + lockNode);
                    return;
                } else {
                    System.out.println("线程：" + Thread.currentThread().getId() + ",等待锁：" + waitNode);
                    //不是最小节点，等待锁释放
                    waitForLock(sessionOut);
                    //锁释放后，再次判断下是否是最小节点
                    if (isLowestNode(content, itemName)) {
                        System.out.println("线程：" + Thread.currentThread().getId() + ",获得锁,节点名称：" + lockNode);
                        return;
                    }
                }
            } catch (Exception e) {
                log.error("加锁异常");
                throw new Exception("加锁异常");
            }
        }


        //判断是否是最小节点
        private boolean isLowestNode(String content, String itemName) throws Exception {
            //获取所有子节点
            List<String> nodeNames = zooKeeper.getChildren(BASE_PATH, null);
            List<String> itemNodes = new ArrayList<>();
            lockNode = itemName;
            //过滤content节点
            for (String name : nodeNames) {
                if (name.split(SPLIT_FLAG)[0].equals(content)) {
                    itemNodes.add(name);
                }
            }
            //排序
            Collections.sort(itemNodes);
            //最小节点返回
            if (itemName.equals(BASE_PATH + "/" + itemNodes.get(0))) {
                return true;
            }

            //非最小节点，找到前一个节点
            int nodeIndex = Collections.binarySearch(itemNodes, itemName.substring(itemName.lastIndexOf("/") + 1));
            waitNode = itemNodes.get(nodeIndex - 1);
            return false;

        }

        //等待锁
        private void waitForLock(final Integer waitTime) throws Exception {

            //判断等待节点是否释放，同时注册watcher，通知释放事件
            Stat stat = zooKeeper.exists(BASE_PATH + "/" + waitNode, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("watch proceess " + watchedEvent.toString());
                    if (countDownLatch != null) {
                        //锁释放，通知等待节点
                        countDownLatch.countDown();
                    }
                }
            });


            //如果等待的锁不存在返回
            if (stat == null) {
                return;
            }
            //存在，等待
            countDownLatch = new CountDownLatch(1);
            countDownLatch.await(waitTime, TimeUnit.MILLISECONDS);

        }


        //释放锁
        public void unLock() throws Exception {
            try {
                //删除锁节点
                zooKeeper.delete(lockNode, -1);
                System.out.println("线程：" + Thread.currentThread().getId() + ",解锁成功，节点名称：" + lockNode);
                lockNode = null;
                zooKeeper.close();
            } catch (Exception e) {
                String errorMsg = "解锁异常,节点名称：" + lockNode;
                log.error(errorMsg);
                throw new Exception(errorMsg);
            }
        }
    }

    //测试任务
    private static class TestJob implements Runnable {
        private NormalLock disLock;
        private String content;


        public TestJob(NormalLock disLock, String content) {
            this.disLock = disLock;
            this.content = content;
        }


        @Override

        public void run() {
            try {
                disLock.lock(content);
                Thread.sleep(2000);
                disLock.unLock();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * 使用ZkClient实现分布式锁测试
     *
     * @throws Exception 异常信息
     */
    private static void normalLockTest() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        String content = "abcdefg";
        String zkHost = "127.0.0.1";
        Integer sessionOut = 30000;
        //创建10个线程测试
        for (int i = 0; i < 10; ++i) {
            NormalLock disLock = new NormalLock(sessionOut, zkHost);
            disLock.init();
            executorService.submit(new TestJob(disLock, content));
        }
        executorService.shutdown();
    }

    private static void process(InterProcessLock lock) {
        System.out.println(Thread.currentThread().getName() + " try to acquire");
        try {
            lock.acquire();
            System.out.println(Thread.currentThread().getName() + " acquire success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " release");
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " release success");
    }

    /**
     * 使用Curator实现分布式锁测试
     */
    private static void CuratorLockTest() {
        String zkAddr = "127.0.0.1:2181";
        String lockPath = "/distribute-lock";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString(zkAddr)
                .sessionTimeoutMs(2000)
                .retryPolicy(retryPolicy)
                .build();
        cf.start();

        InterProcessMutex lock = new InterProcessMutex(cf, lockPath);
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        for (int i = 0; i < 40; i++) {
            executorService.submit(()->{
                process(lock);
            });
        }
        executorService.shutdown();
    }

    public static void main(String[] args) throws Exception {
        CuratorLockTest();
    }
}
