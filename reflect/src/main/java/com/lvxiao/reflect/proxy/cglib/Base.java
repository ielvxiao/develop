package com.lvxiao.reflect.proxy.cglib;

/**
 * CGLIB动态代理被代理类
 * @author lvxiao
 * @date 2020/5/5
 */
public class Base {
    /**
     * 一个模拟的add方法
     */
    public void add() {
        System.out.println("add ------------");
    }
}
