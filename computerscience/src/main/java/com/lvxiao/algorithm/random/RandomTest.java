package com.lvxiao.algorithm.random;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-04-06
 */
public class RandomTest {

    private static final  CountDownLatch latch = new CountDownLatch(100000000);

    private static int getRandomInt() {
        Random random = new Random();
        latch.countDown();
        return random.nextInt();
    }

    private static int getRandomIntThreadLocal() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        latch.countDown();
        return random.nextInt();
    }
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100000000; i++) {
            executor.execute(RandomTest::getRandomInt);
        }
        System.out.println("耗时" + (System.currentTimeMillis() - l));
        executor.shutdown();
    }
}
