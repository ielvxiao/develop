package com.lvxiao.multithread.juc;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/20 10:33 下午
 */
class LockExampleTest {
    private static int a = 0;
    private static CountDownLatch latch = new CountDownLatch(1000);
    //使用自己实现的锁防止出现并发问题
    private static LockExample lock = new LockExample();
    private static void incr() throws InterruptedException {
        latch.await();
        lock.lock();
        a++;
        lock.unlock();
        System.out.println(a);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            latch.countDown();
            service.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    LockExampleTest.incr();
                }
            });
        }
        Thread.sleep(1000);
        System.out.println("增加1000次后A的值："+a);
        service.shutdown();
    }
}
public class LockExample implements Lock {

    private Sync sync = new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(0);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    /**
     * 实现简单的同步器，这里没有考虑重入等问题。
     */
    public static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            //获取当前锁状态
            int c = getState();
            //如果当前未被锁
            if (c == 0) {
                if (compareAndSetState(0, arg)) {
                    //修改过状态后将当前线程设置为独占
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
                return false;
            } else {
                return true;
            }
        }

        @Override
        protected boolean tryRelease(int arg) {
            Thread current = Thread.currentThread();
            if (current != getExclusiveOwnerThread()) {
                throw new UnsupportedOperationException("当前线程未持有锁，所以释放失败");
            }
            setState(arg);
            setExclusiveOwnerThread(null);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }
    }
}
