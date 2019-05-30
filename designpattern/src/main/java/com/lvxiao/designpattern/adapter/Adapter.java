package com.lvxiao.designpattern.adapter;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-05-30 23:19
 */
public class Adapter extends Adaptee implements Target {
    /**
     * 由于源类Adaptee没有方法sampleOperation2()
     * 因此适配器补充上这个方法
     */
    @Override
    public void sampleOperation2() {
        //写相关的代码
    }
}
