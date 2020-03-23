package com.lvxiao.dubbo.manual.async.server;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.TreeMap;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/3/21 5:50 下午
 */
public class AsyncServer {


    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider.xml");
        TreeMap
        context.start();
        System.in.read();
    }
}
