package com.lvxiao.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/22 11:22 下午
 */
public class ZookeeperConnection {




    public static ZooKeeper getConnection() {
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper("localhost:2181", 100000, event -> {
                    System.out.println("收到事件通知：" + event.getState() + "类型" + event.getType()+"路径信息:"+event.getPath());
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return zooKeeper;
    }

    private static void close(ZooKeeper zooKeeper) throws InterruptedException {
        zooKeeper.close();
    }

    public static void main(String[] args) throws InterruptedException, KeeperException {
        ZooKeeper zookeeper = getConnection();
      //  zookeeper.create("/mic","0".getBytes(),ZooDefs.Ids. OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); //创建节点

//        zookeeper.exists("/mic",true); //注册监听
//        zookeeper.setData("/mic", "1".getBytes(),-1) ; //修改节点的值触发监听
        zookeeper.addAuthInfo("digest", "foo:true".getBytes()); //设置权限
//        zookeeper.create("/auth-zk", "init".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT); //创建节点
        System.out.println(zookeeper.getData("/auth-zk", false, null));
    }
}
