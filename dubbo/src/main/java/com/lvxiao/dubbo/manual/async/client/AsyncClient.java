package com.lvxiao.dubbo.manual.async.client;

import com.lvxiao.dubbo.manual.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/3/21 5:48 下午
 */
public class AsyncClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        HelloService asyncService = (HelloService) context.getBean("asyncService");
        System.out.println(asyncService.sayHello("aa"));
        CompletableFuture<String> future = asyncService.sayHelloAsync("异步");
        // 增加回调
        future.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println("Response: " + v);
            }
        });
        System.out.println("主方法结束");
    }
}
