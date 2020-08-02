package com.lvxiao.multithread.communication;

import java.util.concurrent.locks.LockSupport;

/**
 * 如果不加16行与19行，则t1线程被挂起，则主线程也不会结束。
 * 如果添加16行，则t1线程为守护线程，主线程结束后，守护线程自动结束。
 * 如果添加21行，则取消t1线程的挂起状态，t1线程结束，主线程结束，并退出。
 * @author lvxiao
 * @date 2020/8/2
 */
public class ThreadPark {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("me");
            LockSupport.park();
        });
//        t1.setDaemon(true);
        t1.start();
        Thread.sleep(1000);
        LockSupport.unpark(t1);
    }
}
