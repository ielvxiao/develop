package com.lvxiao.algorithm.scope;

/**
 * @author lvxiao
 * @date 2020/5/15
 */
public class ExtendInSamePackage extends Father{

    private void extendInSamePackageTest() {

    }
    public static void main(String[] args) {
        ExtendInSamePackage extendInSamePackage = new ExtendInSamePackage();
        //能够调用defaultScopeTest
        extendInSamePackage.defaultScopeTest();
        Father father = new ExtendInSamePackage();
        father.defaultScopeTest();
        //father不能调用extendInSamePackageTest
        extendInSamePackage.extendInSamePackageTest();
    }
}
