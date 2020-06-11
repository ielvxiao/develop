package com.lvxiao.problem739;

/**
 * @author lvxiao
 * @date 2020/6/11
 */
public class Problem739 {
    public static void main(String[] args) {
        new Problem739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        for (int i = T.length - 2; i > -1; i--) {
            if (T[i] >= T[i + 1]) {
                int tmp = i + 1 + res[i + 1];
                while (T[tmp] <= T[i]) {
                    if (res[tmp] == 0) {
                        res[i] = 0;
                        break;
                    }
                    tmp = res[tmp] + tmp;
                }
                if (T[tmp] > T[i]) {
                    res[i] = tmp-i ;
                }
            } else {
                res[i] = 1;
            }
        }
        return res;
    }
}
