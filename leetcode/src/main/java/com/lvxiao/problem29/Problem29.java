package com.lvxiao.problem29;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/9 8:17 下午
 */
public class Problem29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int flag = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = -1;
        }
        long ldd = Math.abs((long) dividend);
        long ldr = Math.abs((long) divisor);
        int result = 0;
        while (ldd >= ldr) {
            int shift = 0;
            while (ldd >= (ldr << shift)) {
                shift++;
            }
            shift--;
            result += 1 << shift;
            ldd -= ldr << shift;
        }
        return result * flag;
    }

    public static void main(String[] args) {
        new Problem29().divide(-15, -3);
    }
}
