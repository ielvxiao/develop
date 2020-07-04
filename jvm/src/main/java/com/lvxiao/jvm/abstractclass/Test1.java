package com.lvxiao.jvm.abstractclass;

/**
 * @author lvxiao
 * @date 2020/7/4
 */
public class Test1 {
//    void hello(Man man){
//        System.out.println("输入了一个man,我是"+man.getClass().getName());
//    }

    void hello(Human man){
        System.out.println("输入了一个Human,我是"+ man.getClass().getCanonicalName());
        man.say();
    }
}