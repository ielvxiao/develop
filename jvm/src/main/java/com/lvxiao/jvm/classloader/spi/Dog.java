package com.lvxiao.jvm.classloader.spi;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/11 8:46 下午
 */
public class Dog implements Animal {
    @Override
    public void shout() {
        System.out.println("汪汪!🐶");
    }
}
