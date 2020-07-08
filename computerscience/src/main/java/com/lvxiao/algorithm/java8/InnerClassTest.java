package com.lvxiao.algorithm.java8;

/**
 * 匿名内部类可以为任意接口创建实例——不管接口包含多少个抽象方法，只要匿名内部类实现所有的抽象方法即可；但 Lambda 表达式只能为函数式接口创建实例。
 * 匿名内部类可以为抽象类甚至普通类创建实例；但 Lambda 表达式只能为函数式接口创建实例。
 * 匿名内部类实现的抽象方法的方法体允许调用接口中定义的默认方法；但 Lambda 表达式的代码块不允许调用接口中定义的默认方法。
 *
 * @author lvxiao
 * @date 2020/7/8
 */
@FunctionalInterface
interface Displayable {
    // 定义一个抽象方法和默认方法
    void display();

    default int add(int a, int b) {
        return a + b;
    }
}

public class InnerClassTest {
    private int age = 12;
    private static String name = "我是一个字符串";

    public void test() {
        String url = "http://c.biancheng.net/";
        Displayable lamdaDis = () -> {
            // 访问的局部变量
            System.out.println("url 局部变量为:" + url);
            // 访问外部类的实例变量和类变量
            System.out.println("外部类的 age 实例变量为：" + age);
            System.out.println("外部类的 name 类变量为：" + name);
//            System.out.println(add(3, 5));
            System.out.println("lamda表达式在重写内部方法时无法调用其默认方法");
        };
        lamdaDis.display();
        // 调用dis对象从接口中继承的add()方法
        System.out.println(lamdaDis.add(3, 5));

        Displayable innerClassDis = new Displayable() {
            @Override
            public void display() {
                System.out.println(add(3, 5));
                System.out.println("内部类可以执行默认方法");
            }
        };
        innerClassDis.display();
    }

    public static void main(String[] args) {
        InnerClassTest test = new InnerClassTest();
        test.test();

    }
}
