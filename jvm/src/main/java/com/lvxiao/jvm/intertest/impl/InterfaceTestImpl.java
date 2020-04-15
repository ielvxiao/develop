package com.lvxiao.jvm.intertest.impl;

import com.lvxiao.jvm.intertest.InterfaceTest;

/**
 * @author lvxiao
 * @date 2020/4/15
 */
public class InterfaceTestImpl extends InterfaceTest {
    //不能设置为private，因为重写的方法访问权限不能比子类小
    @Override
    public void testProtect() {

    }
}
