package com.lvxiao.spring.aop.demo;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/2 9:01 下午
 */
public class TestPerformance {

    public static void main(String[] args) throws InterruptedException {
        PerformanceMonitor.begin("test1");
        Thread.sleep(100);
        PerformanceMonitor.end();
    }
}
