package com.lvxiao.spring.aop.demo;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/2 8:59 下午
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performanceThreadLocal =
            new ThreadLocal<>();

    public static void begin(String method) {
        System.out.println("开始记录");
        performanceThreadLocal.set(new MethodPerformance(method));
    }

    public static void end() {
        System.out.println("结束记录");
        MethodPerformance mp = performanceThreadLocal.get();
        mp.printPerformance();
    }
}
