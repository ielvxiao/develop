package com.lvxiao.problem1117;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-25 23:38
 */
public class H2O {

    /**
     * 氢原子需要两个
     */
    private Semaphore h = new Semaphore(2);
    /**
     * 氧原子需要一个
     */
    private Semaphore o = new Semaphore(1);
    /**
     * 合成一个原子后才能继续
     */
    private CyclicBarrier barrier = new CyclicBarrier(3);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            barrier.await();
        } catch (Exception e) {
        }
        h.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        try {
            barrier.await();
        } catch (Exception e) {
        }
        o.release();
    }
}
