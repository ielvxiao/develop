package com.lvxiao.redis.lock;

import lombok.SneakyThrows;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author lvxiao
 * @date 2020/4/15
 */
public class DistributedLock extends Thread{
    RLock lock = client.getLock(Thread.currentThread().getName());
    private static int counter = 0;

    static {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://home.com:6379");
        config.setLockWatchdogTimeout(5000);
        client = Redisson.create(config);
    }

    @SneakyThrows
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        lock.lock();
        try {
            counter++;
            TimeUnit.SECONDS.sleep(31);
        }finally {
            lock.unlock();
            System.out.println("运行时间:" + (System.currentTimeMillis() - start));
        }
    }

    private static final RedissonClient client;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new DistributedLock().start();
        }
        System.out.println(counter);
    }
}
