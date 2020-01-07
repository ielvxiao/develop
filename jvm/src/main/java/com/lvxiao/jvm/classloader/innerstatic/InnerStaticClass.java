package com.lvxiao.jvm.classloader.innerstatic;

/**
 * 一、如是否可以创建静态的成员方法与成员变量(静态内部类可以创建静态的成员，而非静态的内部类不可以)
 *
 * 二、对于访问外部类的成员的限制(静态内部类只可以访问外部类中的静态成员变量与成员方法，而非静态的内部类即可以访问所有的外部类成员方法与成员变量)。
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/7 2:36 下午
 */
public class InnerStaticClass {

    private int outer = 1;
    private static int outer1 = 1;

    private static void static1() {
        System.out.println("aaa");
    }
    private static class InnerClass {
        private static int innerStaticInt = 0;
        private int innerInt = 0;
        private int a3 = InnerStaticClass.outer1;
        //无法访问外部非静态变量
        //private int a4 = outer;
    }

    private class InnerClass1 {
        //Inner classes cannot have static declarations 非静态内部类中不可以声明静态成员
        // private static int a1 = 0;
        private int a2 = 0;
        //内部类可以访问外部类的私有属性
        private int a3 = InnerStaticClass.outer1;
        private int a4 = outer;
    }
}
