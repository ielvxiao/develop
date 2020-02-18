package com.lvxiao.multithread.poll;

import java.util.concurrent.*;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/18 10:58 下午
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        //创建线程的几种方式，这几种方式都是存在问题的，其根本原因在于底层都是使用的ThreadPoolExecutor创建线程池但是参数设置有问题


        /*
        存在问题 LinkedBlockingQueue最大容量为Integer.MAX_VALUE，所以可能会造成大量请求堆积，造成OOM
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService = Executors.newSingleThreadExecutor();
        /*
        存在问题，允许的最大线程数为Integer.MAX_VALUE，会创建大量线程，造成OOM
         */
        executorService = Executors.newCachedThreadPool();
        executorService = Executors.newScheduledThreadPool(1);


        /*
        解决办法，使用ThreadPoolExecutor设置有边界的Queue和合理的最大线程数，并结合合理的拒绝策略。
         */
        executorService = new ThreadPoolExecutor(1, 4, 0,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }
}
