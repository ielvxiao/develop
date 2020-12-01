package com.lvxiao.algorithm.regexp;

import java.util.regex.Pattern;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-12-01
 */
public class RegExpTest {
    public static void main(String[] args) {
        String digitExp = "[0-9]"; //匹配单个数字
        System.out.println(Pattern.compile(digitExp).matcher("1").matches());
        String digitExp1 = "^\\d*$"; //匹配多位数字
        System.out.println(Pattern.compile(digitExp1).matcher("12").matches());
        String digitExp2 = "^\\d{3}$"; //匹配3位数字
        System.out.println(Pattern.compile(digitExp2).matcher("1234").matches());
        String digitExp3 = "^\\d{3,}$"; //匹配最少3位数字的数字
        System.out.println(Pattern.compile(digitExp3).matcher("12").matches());
        String digitExp4 = "^[1]\\d{10}$"; //1开头后边10个数字
        System.out.println(Pattern.compile(digitExp4).matcher("10123456789").matches());

    }
}
