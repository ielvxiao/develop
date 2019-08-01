package com.lvxiao.problem1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115. Print FooBar Alternately
 * @author lvxiao
 * @date 2019/7/23
 */
public class FooBar {
    private int n;
    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    private int state = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                if (state != 0) {
                    conditionA.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                state = 1;
                conditionB.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                if (state != 1) {
                    conditionB.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                state = 0;
                conditionA.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
