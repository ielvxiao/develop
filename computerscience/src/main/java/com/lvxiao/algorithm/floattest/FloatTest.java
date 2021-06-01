package com.lvxiao.algorithm.floattest;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-05-31
 */
public class FloatTest {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(9.1f)));
        test(); //1丢了？
        floatTest(); //存在丢失问题
        kahanSummation();
    }

    public static void test() {
        float f = 20000000f;
        float x = 1.0f;
        System.out.println(f+x);
    }
    public static void floatTest() {
        float sum = 0.0f;
        for (int i = 0; i < 20000000; i++) {
            float x = 1.0f;
            sum += x;
        }
        System.out.println("sum is " + sum);
    }
    public static void kahanSummation() {
        float sum = 0.0f;
        float c = 0.0f;
        for (int i = 0; i < 20000000; i++) {
            float x = 1.0f;
            float y = x - c;
            float t = sum + y;
            c = (t - sum) - y;

            sum = t;
        }
        System.out.println("sum is " + sum);
    }
}
