package com.lvxiao.spring.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/3/10 3:00 下午
 */
@Component
public class AsyncAnnotationExample {
    //指定线程池
    @Async("testExecutor")
    public void printMessage() throws InterruptedException {
        System.out.println("子线程开始");
//        TimeUnit.SECONDS.sleep(1);
        System.out.println("=======当前线程为：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncTestConfig.class);
        System.out.println("主线程开始！！");
        AsyncAnnotationExample bean = context.getBean(AsyncAnnotationExample.class);
        for (int i = 0; i < 10; i++) {
            bean.printMessage();
        }
        System.out.println("======================主线程结束！！");
        context.close();
    }
}
