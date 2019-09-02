package com.lvxiao.reflect.classloader;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-08-11 17:06
 */
public class GetClassLoader {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("获取到的loader是：" + loader);
        System.out.println("获取到的loader getParent是：" + loader.getParent());
        System.out.println("获取到的loader getParent getParent是：" + loader.getParent().getParent());
    }
}
