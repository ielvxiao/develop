package com.lvxiao.multithread.create;

import java.util.concurrent.*;

/**
 * 如何创建线程
 * 1. 继承Thread
 * 2. 实现Runnable接口
 * 3. 实现Callable接口
 * 4. 通过线程池
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-18 10:53
 */
class Base {
    protected static int anInt = 0;

}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println(Base.anInt++);
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Base.anInt++);
    }
}

class Thread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return Base.anInt++;
    }
}

public class CreateThread {


    public static void main(String[] args) throws Exception {
        //method1
        Thread thread1 = new Thread1();
        thread1.setName("extendThread");
        thread1.start();
        //method2
        Thread thread2 = new Thread(new Thread2());
        thread2.setName("implementRunable");
        thread2.start();
        //method3
        Callable<Integer> thread3 = new Thread3();
        FutureTask<Integer> task = new FutureTask<>(thread3);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
        task.run();
        //使用线程池Executors创建
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> futureTask = service.submit(new Thread3());
        System.out.println(futureTask.get());
        service.shutdown();
        //使用推荐的方式创建线程。
        ExecutorService threadPool = new ThreadPoolExecutor(1, 5, 30, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        System.out.println(threadPool.submit(new Thread3()).get());
        threadPool.shutdown();
    }
}
