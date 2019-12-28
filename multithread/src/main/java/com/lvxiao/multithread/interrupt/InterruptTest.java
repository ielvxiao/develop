package com.lvxiao.multithread.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(() -> InterruptTest.test1());
//            Thread.currentThread().interrupt();
        }
    }
}
