import static org.junit.Assert.assertTrue;

import java.time.ZonedDateTime;
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
}
