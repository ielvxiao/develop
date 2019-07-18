package com.lvxiao.multithread.juc;

import java.util.concurrent.Semaphore;

/**
 * Semaphore，又名信号量，这个类的作用有点类似于“许可证”。有时，我们因为一些原因需要控制同时访问共享资源的最大线程数量，比如出于系统性能的考虑需要限流，或者共享资源是稀缺资源，我们需要有一种办法能够协调各个线程，以保证合理的使用公共资源。
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-18 18:27
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore sm = new Semaphore(3, true);


    }
}
