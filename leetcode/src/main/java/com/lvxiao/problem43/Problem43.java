package com.lvxiao.problem43;


import java.util.Arrays;

/**
 * 43. Multiply Strings
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/4 8:52 下午
 */
public class Problem43 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i > -1; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j > -1; j--) {
                int b = num2.charAt(j) - '0';
                int c = a * b + res[i + j + 1];
                res[i + j + 1] = c % 10;
                res[i + j] += c / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean go = false;
        for (int i = 0; i < res.length; i++) {
            if (go || res[i] > 0) {
                go = true;
                sb.append(res[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Problem43.multiply("123", "456"));
    }
}
