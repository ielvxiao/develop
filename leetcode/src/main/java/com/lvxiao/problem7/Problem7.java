package com.lvxiao.problem7;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-10 22:24
 */
public class Problem7 {
    public int reverse(int x) {
        int res = 0;
        int pop = 0;
        while (x !=0) {
            pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = 10 * res + pop;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem7().reverse(321));
    }
}
