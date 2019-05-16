package com.lvxiao.designpattern.adapter.demo1;

/**
 * @author lvxiao
 * @date 2019/5/16
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
