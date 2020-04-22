package com.lvxiao.multithread.lock;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvxiao
 * @date 2020/4/20
 */
public class LockCompare {

    private static int counter = 0;

    private final Lock lock = new ReentrantLock();
    public void synchronizedTest() {
        synchronized (this) {
            counter++;
        }
    }

    public void reentrantLockTest() {
        lock.lock();
        try {
            counter++;
        }finally {
            lock.unlock();

        }
    }

    @SneakyThrows
    public static void main(String[] args) {

        LockCompare lockCompare = new LockCompare();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executorService.execute(lockCompare::synchronizedTest);
        }
        executorService.shutdown();
        System.out.println(counter);
        Thread.sleep(10000);
        System.out.println(counter);
    }
}
