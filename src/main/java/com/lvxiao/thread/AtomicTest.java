package com.lvxiao.thread;


import lombok.Synchronized;
import lombok.extern.log4j.Log4j2;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvxiao
 * @date 2019/5/17
 */
class Sample1 {
    private static Integer count = 0;
    public final static Object o = new Object();

    public static void increment() {
        synchronized (o) {
            count++;
        }
    }

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        Set<Integer> set = new HashSet<>();
        Sample1 sample1 = new Sample1();
        for (int i = 0; i < 1000; i++) {

            new Thread(() -> {
                sample1.increment();
                boolean isNoDuplicate = set.add(count);
                if (!isNoDuplicate) {
                    System.out.println("hahahah重复了：" + count);
                }
            }).start();
        }
    }
}

@Log4j2
public class AtomicTest {

    private Lock lock = new ReentrantLock();

    //全局变量
    private static AtomicInteger a = new AtomicInteger(0);


    private static int atomicPlus(AtomicInteger a) {
        return a.incrementAndGet();
    }

    private static int generalPlus(int b) {
        b++;
        return b;
    }

    private static Integer b = 0;

    @Synchronized
    private static void synchronizedPlu() {
        AtomicTest.b++;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                AtomicTest.synchronizedPlu();
                boolean isNoDuplicate = set.add(b);

            });
        }
        executorService.shutdown();
    }
}
