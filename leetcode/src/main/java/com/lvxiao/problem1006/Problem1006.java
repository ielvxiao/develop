package com.lvxiao.problem1006;

/**
 * @author lvxiao
 * @date 2021/4/1
 */
public class Problem1006 {
    public int clumsy(int N) {
        int res = 0;
        int tmp = 0;
        int a = 1;
        for (int i = 0; i < N; i++) {
            int index = i % 4;
            int value = N - i;
            switch (index) {
                case 0:
                    tmp = value * a;
                    a = -1;
                    break;
                case 1:
                    tmp *= value;
                    break;
                case 2:
                    tmp /= value;
                    res += tmp;
                    tmp = 0;
                    break;
                case 3:
                    res += value;
                    break;
            }
        }
        return res + tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1006().clumsy(4));
    }
}
