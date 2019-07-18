package com.lvxiao.multithread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 倒数计数器，构造时设定计数值，当计数值归零后，所有阻塞线程恢复执行；其内部实现了AQS框架
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-18 17:35
 */
class Do implements Runnable {
    private CountDownLatch latch;

    public Do(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("哈哈哈哈哈哈开始执行了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Worker implements Runnable {
    private CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("倒计时：" + latch.getCount());
        latch.countDown();
    }
}
public class CountDownLatchTest {
    private static final int N = 10;
    private static CountDownLatch countDownLatch;

    /**
     * 作为程序入口使用
     */
    public static void togtherDo() {
        //倒计时一个数
        countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < N; i++) {
            new Thread(new Do(countDownLatch)).start();
        }
        System.out.println("准备！~！！！！！！！！！");
        //倒计时结束后，上述N个线程一起执行！
        countDownLatch.countDown();
    }

    /**
     * 用作完成任务标记，一起完成后执行某一事件
     */
    public static void finishWork() throws InterruptedException {
        countDownLatch = new CountDownLatch(N);
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(countDownLatch)).start();
        }
        countDownLatch.await();
        //只有countDownLatch执行结束才能执行以下打印操作
        System.out.println("运行结束！");
    }
    public static void main(String[] args) throws InterruptedException {
//        CountDownLatchTest.togtherDo();
        CountDownLatchTest.finishWork();
    }
}
