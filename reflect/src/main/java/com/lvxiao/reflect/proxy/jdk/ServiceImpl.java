package com.lvxiao.reflect.proxy.jdk;

/**
 * JDK代理，实现接口
 * @author lvxiao
 * @date 2020/5/5
 */
public class ServiceImpl implements Service {

    public void add() {
        System.out.println("AService add>>>>>>>>>>>>>>>>>>");
    }


    public void update() {
        System.out.println("AService update>>>>>>>>>>>>>>>");
    }
}

