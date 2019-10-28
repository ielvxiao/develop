package com.lvxiao.multithread.communication;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/28 2:59 下午
 */
public class ThreadWaitTest extends Thread {


    private String name;
    private Object prev;
    private Object self;

    private ThreadWaitTest(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadWaitTest pa = new ThreadWaitTest("A", c, a);
        ThreadWaitTest pb = new ThreadWaitTest("B", a, b);
        ThreadWaitTest pc = new ThreadWaitTest("C", b, c);
        new Thread(pa).start();
        Thread.sleep(100);
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}
