package com.lvxiao.algorithm.s;

/**
 * switch语句原理是跳转到caseX位置执行剩下所有的语句（包括其他case里面的），直到最后或者遇见break为止。
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-04-05
 */
public class SwitchTest {

    private static void test(int num) {
        switch (num) {
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            default:
                System.out.println(0);
        }
    }
    public static void main(String[] args) {
        SwitchTest.test(2);
    }
}
