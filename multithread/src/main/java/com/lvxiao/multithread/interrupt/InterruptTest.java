package com.lvxiao.multithread.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/28 8:23 下午
 */
public class InterruptTest {

    private static void test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "运行到了：" + i);
            if (i % 5 == 0) {
                Thread.currentThread().interrupt();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //由于被interrupt，所以sleep直接失效，然后程序继续执行。
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * false
     * false
     * false
     * true
     * false
     * false
     * false
     * 很多false包围了一个true，也就是interrupted方法判断了中断，然后擦除了标记，后边再判断都是false了
     * @throws InterruptedException
     */
    public static void testInterrupted() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.interrupted());
            }
        });
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }

    public static void main(String[] args)  {
        System.out.println("Main thread is interrupted before ? "+Thread.interrupted()); //返回false,因为没有被中断
        Thread.currentThread().interrupt();
        System.out.println("Main thread is interrupted? "+Thread.currentThread().isInterrupted()); //因为中断所以返回true

//        System.out.println("Main thread is interrupted after ? "+Thread.interrupted()); //加上这句不会进入异常咯？？ 可能是还没进到异常里边，状态被清除了

        System.out.println("Main thread is interrupted? "+Thread.currentThread().isInterrupted()); //如果加上注释行，则会返回false，否则是true。
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("中断咯~~");
        }
    }
}
