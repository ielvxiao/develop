import static org.junit.Assert.assertTrue;

import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Test;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-09-15
 */
public class GuavaTest {

    @Test
    public void guavaRateLimiterTest() {
        // given
        RateLimiter rateLimiter = RateLimiter.create(100);

        // when
        long startTime = ZonedDateTime.now().getSecond();
        rateLimiter.acquire(100);
        //        doSomeLimitedOperation();
        long elapsedTimeSeconds = ZonedDateTime.now().getSecond() - startTime;
        // then
        assertTrue(elapsedTimeSeconds <= 1);
    }

    @Test
    public void givenLimitedResource_whenUseRateLimiter_thenShouldLimitPermits() {
        // given
        RateLimiter rateLimiter = RateLimiter.create(1);

        // when
        long startTime = ZonedDateTime.now().getSecond();
        IntStream.range(0, 11).forEach(i -> {
            rateLimiter.acquire();
            System.out.println(ZonedDateTime.now().getSecond() - startTime);
        });
        long elapsedTimeSeconds = ZonedDateTime.now().getSecond() - startTime;
        System.out.println(elapsedTimeSeconds);
        // then
        assertTrue(elapsedTimeSeconds >= 10);
    }

    @Test
    public void testSmoothBursty2() {
        RateLimiter r = RateLimiter.create(5);
        while (true) {
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            try {
                Thread.sleep(1300);
            } catch (Exception e) {
            }
            //如果有n个permits，则再等待超过1+1/n秒后，则可以直接获取1+n个permits
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("end");
            /**
             * output:
             * get 1 tokens: 0.0s
             * get 1 tokens: 0.0s
             * get 1 tokens: 0.0s
             * get 1 tokens: 0.0s
             * end
             * get 1 tokens: 0.499796s
             * get 1 tokens: 0.0s
             * get 1 tokens: 0.0s
             * get 1 tokens: 0.0s
             */
        }
    }

    @Test
    public void testSmoothwarmingUp() {
        RateLimiter r = RateLimiter.create(2, 3, TimeUnit.SECONDS);
        while (true) {
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("end");
            /**
             * output:
             * get 1 tokens: 0.0s
             * get 1 tokens: 1.329289s
             * get 1 tokens: 0.994375s
             * get 1 tokens: 0.662888s  The total amount of time that has been taken for acquiring these three tokens is 3s.
             * end
             * get 1 tokens: 0.49764s  Tokens are acquired at the normal rate of two tokens/s.
             * get 1 tokens: 0.497828s
             * get 1 tokens: 0.49449s
             * get 1 tokens: 0.497522s
             */
        }
    }
}
