package com.lvxiao.jvm.classloader.classforname;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/17 4:24 下午
 */
public class DomainTest {

    private int anInt = 0;
    private static int aStatic = 1;

    {
        System.out.println("I'm normal block!");
        System.out.println("anInt是：" + anInt);
    }

    static {
        System.out.println("aStatic是：" + aStatic);
        System.out.println("I'm static block!");
    }
}
