package com.lvxiao.jvm.abstractclass;

/**
 * @author lvxiao
 * @date 2020/7/4
 */
class Man extends Human{
    @Override
    void say() {
        System.out.println("我不是原始人啦！");
    }
}
public abstract class Human {
    void say(){
        System.out.println("我是原始人");
    }
}
