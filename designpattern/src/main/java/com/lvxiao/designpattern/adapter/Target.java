package com.lvxiao.designpattern.adapter;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-05-30 23:19
 */
public interface Target {
    /**
     * 这是源类Adaptee也有的方法
     */
    void sampleOperation1();

    /**
     * 这是源类Adapteee没有的方法
     */
    void sampleOperation2();
}
