package com.lvxiao.jvm.classloader.shutdownhook;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/9 11:46 下午
 */
public class ShutDownHook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()-> System.out.println("JVM关闭之前我是不是要做点什么？？")));
        System.out.println("我执行了一段业务代码");
       // Runtime.getRuntime().halt(0); 如果添加这一段代码则不会执行ShutDownHook
    }
}
