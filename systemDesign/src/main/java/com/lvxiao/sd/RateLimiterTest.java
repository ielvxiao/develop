package com.lvxiao.sd;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * RateLimiter 从概念上来讲，速率限制器会在可配置的速率下分配许可证。如果必要的话，每个acquire()
 * 会阻塞当前线程直到许可证可用后获取该许可证。一旦获取到许可证，不需要再释放许可证。
 *
 * 输出结果：
 * I have acquired a permit~~😆
 * time is 2020-09-15 15:13:31 080
 * failed to acquire 😢
 * time is 2020-09-15 15:13:31 188
 * failed to acquire 😢
 * time is 2020-09-15 15:13:31 291
 * failed to acquire 😢
 * time is 2020-09-15 15:13:31 393
 * I have acquired a permit~~😆
 * time is 2020-09-15 15:13:31 499
 * failed to acquire 😢
 * time is 2020-09-15 15:13:31 600
 * failed to acquire 😢
 * time is 2020-09-15 15:13:31 701
 * failed to acquire 😢
 * time is 2020-09-15 15:13:31 802
 * failed to acquire 😢
 * time is 2020-09-15 15:13:31 905
 * I have acquired a permit~~😆
 * time is 2020-09-15 15:13:32 010
 * failed to acquire 😢
 * time is 2020-09-15 15:13:32 111
 * failed to acquire 😢
 * time is 2020-09-15 15:13:32 216
 * failed to acquire 😢
 * time is 2020-09-15 15:13:32 316
 * failed to acquire 😢
 * time is 2020-09-15 15:13:32 417
 * I have acquired a permit~~😆
 * time is 2020-09-15 15:13:32 519
 * <p>
 * 可以看出来，RateLimiter除了会对每秒的访问频次做限制，还会控制两个请求之间的时间。
 *
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-09-15
 */
public class RateLimiterTest {

    final static RateLimiter LIMITER = RateLimiter.create(2.0);
    //时间转字符串格式化
    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");

    static class ThreadTest extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (LIMITER.tryAcquire()) {
                    System.out.println("I'm " + Thread.currentThread().getName() + "I have acquired a permit~~😆");
                } else {
                    System.out.println("I'm " + Thread.currentThread().getName() + "failed to acquire 😢");
                }
                String dateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
                System.out.println("time is " + dateTime);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ThreadTest();
        Thread t2 = new ThreadTest();
        t1.start();
        t2.start();

    }
}
