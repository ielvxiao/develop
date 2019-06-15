package com.lvxiao.multithread.threadlocal;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * ThreadLocal的使用
 * @author lvxiao
 * @date 2019/6/15
 */
class TestThread implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(1L);//让线程停顿一下，便于其它线程执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TreadLocalTest.local.set(Thread.currentThread().getId()+":"+System.currentTimeMillis());
        TreadLocalTest.local2.set(Thread.currentThread().getId()+"");
        firstStep();
        try {
            Thread.sleep(1L);//让线程停顿一下，便于其它线程执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        secondStep();
        try {
            Thread.sleep(1L);//让线程停顿一下，便于其它线程执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        thirdStep();
        try {
            Thread.sleep(1L);//让线程停顿一下，便于其它线程执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        fourthStep();
        try {
            Thread.sleep(1L);//让线程停顿一下，便于其它线程执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        fStep();
    }

    public void firstStep(){
        System.out.println(TreadLocalTest.local.get().toString()+":first step");//获取本线程的threadlocal变量值并打印
    }
    public void secondStep(){
        System.out.println(TreadLocalTest.local.get().toString()+":second step");
    }
    public void thirdStep(){
        System.out.println(TreadLocalTest.local.get().toString()+":third step");
    }
    public void fourthStep(){
        System.out.println(TreadLocalTest.local.get().toString()+":fourth step");
    }
    public void fStep(){
        System.out.println(TreadLocalTest.local.get().toString()+":fifth step");
    }
}
public class TreadLocalTest {
    public static ThreadLocal<String> local = new ThreadLocal<String>();//声明静态的threadlocal变量
    public static ThreadLocal<String> local2 = new ThreadLocal<String>();//声明静态的threadlocal变量

    public static void main(String[] args) {
        //使用guava提供的第三方包创建ThreadFactory
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        //不要使用Executors.fix...这些创建线程池，原因google
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 30, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024), threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 5; i++) {
            executorService.execute(new TestThread());
        }
        executorService.shutdown();
    }
}
