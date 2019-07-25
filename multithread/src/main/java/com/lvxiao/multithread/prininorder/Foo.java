package com.lvxiao.multithread.prininorder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-23 00:17
 */
public class Foo {

    private ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    //控制顺序
    int state = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            if (state != 1) {
                conditionA.await();
            }
            //执行2
            state = 2;
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            conditionB.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            if (state != 2) {
                conditionB.await();
            }
            //执行3
            state = 3;
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            if (state != 3) {
                conditionC.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
