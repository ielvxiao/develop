package com.lvxiao.multithread.future;


import java.util.concurrent.*;

/**
 * Future和FutureTask基本一样，他们和普通的线程运行的不同是可以有返回值，通过get()方法获取返回值，但是get()方法是阻塞的。
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/1 6:03 下午
 */
class Test1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("执行了Callable thread");
        return 1;
    }
}
class Test2 implements Runnable {

    @Override
    public void run() {
        System.out.println("执行了Runnable thread");
    }
}
public class FutureTest {
    public static void test1() {

    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
           Future future = service.submit(new Test1());
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        FutureTask<Integer> t1 = new FutureTask(new Test2(), 100); //如果传入Runnable(),则还需要传入一个返回默认值，就是get()返回的值
        service.submit(t1);
        System.out.println(t1.get());
        service.shutdown();
    }
}
