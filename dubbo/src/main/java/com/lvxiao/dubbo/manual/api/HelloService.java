package com.lvxiao.dubbo.manual.api;


import java.util.concurrent.CompletableFuture;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/3/21 6:36 下午
 */
public interface HelloService {
    String sayHello(String name);

    CompletableFuture<String> sayHelloAsync(String name);
}
