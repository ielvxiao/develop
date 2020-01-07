package com.lvxiao.problem48;

import java.util.Arrays;

/**
 * a
 * d   b
 * c
 * 先交换
 *
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/7 6:21 下午
 */
public class Problem48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp_b = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                int tmp_c = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = tmp_b;
                int tmp_d = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = tmp_c;
                matrix[i][j] = tmp_d;
            }
        }
    }

    public static void main(String[] args) {
        new Problem48().rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
    }
}
