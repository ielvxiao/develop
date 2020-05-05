package com.lvxiao.reflect.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author lvxiao
 * @date 2020/5/5
 */
public class CglibProxyTest {

    /**
     * 这个方法产生了一个新的class文件！
     * @param proxy
     * @return
     */
    public static Base getInstance(CglibProxy proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        //回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法
        enhancer.setCallback(proxy);
        // 此刻，base不是单纯的目标类，而是增强过的目标类
        Base base = (Base) enhancer.create();
        return base;
    }

    public static void main(String[] args) {
        Base base = CglibProxyTest.getInstance(new CglibProxy());
        base.add();
    }
}
