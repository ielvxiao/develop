package com.lvxiao.multithread.poll;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/30 2:03 下午
 */
public class ThreadPoolTest {

    private ThreadPoolExecutor pool;

    private class CustomThreadFactory implements ThreadFactory{
        private AtomicInteger count = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = ThreadPoolTest.class.getSimpleName() + count.addAndGet(1);
            System.out.println(threadName);
            t.setName(threadName);
            return t;
        }
    }
    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // 记录异常
            // 报警处理等
            System.out.println("error.............");
        }
    }

    /**
     * 线程池初始化方法
     *
     * corePoolSize 核心线程池大小----10
     * maximumPoolSize 最大线程池大小----30
     * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间----30+单位TimeUnit
     * TimeUnit keepAliveTime时间单位----TimeUnit.MINUTES
     * workQueue 阻塞队列----new ArrayBlockingQueue<Runnable>(10)====10容量的阻塞队列
     * threadFactory 新建线程工厂----new CustomThreadFactory()====定制的线程工厂
     * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,
     * 							即当提交第41个任务时(前面线程都没有执行完,此测试方法中用sleep(100)),
     * 						          任务会交给RejectedExecutionHandler来处理
     */
    public void init() {
        this.pool = new ThreadPoolExecutor(
                10,
                30,
                30,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10),
                new CustomThreadFactory(),
                new CustomRejectedExecutionHandler()
        );
    }

    public ThreadPoolExecutor getPool() {
        return this.pool;
    }
    public static void main(String[] args) {
        ThreadPoolTest test = new ThreadPoolTest();
        test.init();
        ThreadPoolExecutor poolExecutor = test.getPool();
        for (int i = 0; i < 100; i++) {
            System.out.println("提交第"+i+"个任务");
            poolExecutor.execute(()->
            {
                System.out.println(">>>task is running=====poolSize:"+poolExecutor.getPoolSize()
                +"。corePoolSize："+poolExecutor.getCorePoolSize()+"。activeCount："+poolExecutor.getActiveCount()+"。queueSize："+poolExecutor.getQueue().size());

                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        poolExecutor.shutdown();
    }
}
