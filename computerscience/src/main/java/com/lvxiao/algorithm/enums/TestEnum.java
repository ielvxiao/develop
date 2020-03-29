package com.lvxiao.algorithm.enums;

/**
 * @author lvxiao
 * @date 2020/3/29
 */
class Main {
    public static void main(String[] args) {
        System.out.println(TestEnum.STATUS.name()); //输出name
        System.out.println(TestEnum.STATUS.ordinal()); //输出ordinal
        System.out.println(TestEnum.TEST.ordinal()); //输出ordinal

    }
}
public enum  TestEnum {
    STATUS,
    TEST;

    //这是一个final方法不能覆盖
//    public String name() {
//
//    }
}
