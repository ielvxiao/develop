package com.lvxiao.multithread.communication;


import java.util.concurrent.CountDownLatch;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/28 2:15 下午
 */
public class ThreadYieldTest extends Thread {
    private String name;

    private static CountDownLatch latch = new CountDownLatch(5);
    public ThreadYieldTest(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        latch.countDown();
        for (int i = 0; i < 50; i++) {
            System.out.println("====线程"+Thread.currentThread().getName()+"的第"+i+"轮");
            if (i == 30) {
                yield();
                System.out.println("线程"+Thread.currentThread().getName()+"yield!!!!!!!!!!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadYieldTest a = new ThreadYieldTest("A");
        ThreadYieldTest b = new ThreadYieldTest("B");
        ThreadYieldTest c = new ThreadYieldTest("C");
        ThreadYieldTest d = new ThreadYieldTest("D");
        ThreadYieldTest e = new ThreadYieldTest("E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        latch.await();
    }
}
