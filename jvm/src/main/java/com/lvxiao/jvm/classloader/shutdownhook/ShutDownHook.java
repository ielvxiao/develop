package com.lvxiao.jvm.classloader.shutdownhook;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * 如果发送kill -15则不会中断Shutdown hook，如果发送kill -9或者执行Runtime.getRuntime().halt(0)，则Shutdown hook可能不会执行成功。
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/9 11:46 下午
 */
class MyShutdownHook extends Thread{
    @SneakyThrows
    @Override
    public void run() {
        System.out.println("准备执行资源清理");
        TimeUnit.SECONDS.sleep(100);
        System.out.println("已经执行资源清理");
    }
}
public class ShutDownHook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new MyShutdownHook());
        System.out.println("我执行了一段业务代码");
       // Runtime.getRuntime().halt(0); 如果添加这一段代码则不会执行ShutDownHook
    }
}
