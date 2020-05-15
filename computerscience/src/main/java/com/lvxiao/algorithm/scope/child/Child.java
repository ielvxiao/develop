package com.lvxiao.algorithm.scope.child;

import com.lvxiao.algorithm.scope.Father;

/**
 * @author lvxiao
 * @date 2020/5/15
 */
public class Child extends Father {
    @Override
    protected void protectedTest() {
        super.protectedTest();
    }

    @Override
    public void publicTest() {
        super.publicTest();
    }
}
