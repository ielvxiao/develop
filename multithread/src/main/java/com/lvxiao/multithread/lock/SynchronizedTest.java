package com.lvxiao.multithread.lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/17 2:08 下午
 */
public class SynchronizedTest {

    private static void noLock() {
        SynchronizedTest test = new SynchronizedTest();
        /*
        01 00 00 00 (00000001 00000000 00000000 00000000) (1)无锁状态
         */
        System.out.println(ClassLayout.parseInstance(test).toPrintable());
    }

    private static void biasedLock() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SynchronizedTest test = new SynchronizedTest();
        /*
        05 00 00 00 (00000101 00000000 00000000 00000000) (5) 代表偏向锁状态(此时这个偏向锁正处于可偏向状态，准备好进行偏向了！你也可以理解为此时的偏向锁是一个特殊状态的无锁。)
         */
        System.out.println(ClassLayout.parseInstance(test).toPrintable());
    }

    private static void biasedLockReal() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SynchronizedTest test = new SynchronizedTest();
        synchronized (test) {
            /*
            05 10 00 96 (00000101 00010000 00000000 10010110) (-1778380795) 对象头发生了明显的变化，但是还是偏向锁
             */
            System.out.println(ClassLayout.parseInstance(test).toPrintable());
        }

    }

    private static void lightWeightLock() throws InterruptedException {
        Thread.sleep(5000);
        SynchronizedTest a = new SynchronizedTest();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread1 locking");
                    /*
                    05 78 03 c9 (00000101 01111000 00000011 11001001) (-922519547) 输出偏向锁
                     */
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
                try {
                    //thread1退出同步代码块，且没有死亡
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread2 locking");
                    /*
                    b8 a9 91 0e (10111000 10101001 10010001 00001110) (244427192) 输出轻量级锁
                     */
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };
        thread1.start();

        //让thread1执行完同步代码块中方法。
        Thread.sleep(3000);
        thread2.start();
    }

    private static void heavyWightLock() throws InterruptedException {
        Thread.sleep(5000);
        SynchronizedTest a = new SynchronizedTest();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread1 locking");
                    /*
                    0a 96 01 4a (00001010 10010110 00000001 01001010) (1241617930) 重量级锁
                     */
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    try {
                        //让线程晚点儿死亡，造成锁的竞争
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread2 locking");
                    /*
                    0a 96 01 4a (00001010 10010110 00000001 01001010) (1241617930) 重量级锁
                     */
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest.heavyWightLock();
    }
}
