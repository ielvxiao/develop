package com.lvxiao.spring.aop.demo;

import lombok.Data;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/2 8:56 下午
 */
@Data
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        long elapse = System.currentTimeMillis() - begin;
        System.out.println(serviceMethod + "花费了" + elapse + "毫秒。");
    }
}
