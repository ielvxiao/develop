package com.lvxiao.problem1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-25 22:39
 */
public class ZeroEvenOdd {
    private int n;
    //代码块锁
    private Object object = new Object();
    //输出0的可见性锁
    private volatile boolean zeroState = false;
    //输出偶数的可见性锁
    private volatile boolean evenState = true;
    //输出奇数的可见性锁
    private volatile boolean oddState = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (object) {
                while (zeroState) {
                    object.wait();
                }
                printNumber.accept(0);
                zeroState = true;
                if(i%2==0){
                    evenState = false;
                    oddState = true;
                }else{
                    oddState = false;
                    evenState = true;
                }
                object.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (object) {
                while (evenState) {
                    object.wait();
                }
                if (i % 2 == 0) {
                    printNumber.accept(i);
                }
                evenState = true;
                oddState = true;
                zeroState = false;
                object.notifyAll();
            }

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            synchronized (object) {
                while (oddState) {
                    object.wait();
                }
                if (i % 2 == 1) {
                    printNumber.accept(i);
                }
                oddState = true;
                evenState = true;
                zeroState = false;
                object.notifyAll();
            }

        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
