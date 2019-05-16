package com.lvxiao.designpattern.adapter.demo1;

/**
 * @author lvxiao
 * @date 2019/5/16
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
