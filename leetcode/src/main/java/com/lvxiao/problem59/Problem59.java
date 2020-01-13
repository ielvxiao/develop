package com.lvxiao.problem59;

import java.util.Arrays;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/12 5:10 下午
 */
public class Problem59 {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        int c1 = 0, c2 = n - 1;
        int r1 = 0, r2 = n - 1;
        int k = 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) res[r1][c] = k++;
            for (int r = r1 + 1; r <= r2; r++) res[r][c2] = k++;
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) res[r2][c] = k++;
                for (int r = r2; r > r1; r--) res[r][c1] = k++;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem59().generateMatrix(9)));
    }
}
