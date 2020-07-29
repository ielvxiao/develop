package com.lvxiao.jvm.classloader.order;

/**
 * @author lvxiao
 * @date 2020/7/29
 */
class Aa{
    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("非静态代码块");
    }
    public static int x = 10;
}
public class TestStatic {
    public static void main(String[] args) {
        System.out.println("aaaa");
        //当访问Aa的时候才会触发Aa的初始化
        System.out.println(Aa.x);
        //调用new方法触发实例化
        Aa a = new Aa();
    }
}
