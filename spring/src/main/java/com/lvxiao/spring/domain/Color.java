package com.lvxiao.spring.domain;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-02 12:15
 */
public class Color {
    public void init() {
        System.out.println("创建了Color");
    }

    public void destroy() {
        System.out.println("调用了销毁方法！");
    }
}
