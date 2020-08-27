package com.lvxiao.algorithm.floattest;

import java.math.BigDecimal;

/**
 *
 * @author lvxiao
 * @date 2020/8/27
 */
public class BigDecimalTest {
    public static void main(String[] args) {

        /*
        使用bigdecaimal的时候不要直接使用double作为入参，这样会导致精度丢失，要使用String入参或者是使用valueOf方法
         */
        double value = 0.1d;

        BigDecimal bigDecimal
               // = new BigDecimal(value);// 直接使用double入参会出现问题  最后的bigdecimal值是0.1000000000000000055511151231257827021181583404541015625
                = BigDecimal.valueOf(value);
        System.out.println(bigDecimal);

        /*
        BigDecimal比较用CompareTo,因为用equals如果精度不同的时候会导致精度丢失
         */
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("1.00");
        System.out.println(a.equals(b));
        System.out.println(a.compareTo(b)==0);
    }
}
