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
        final int m = matrix[0].length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        System.out.println(1);
    }

    public static void main(String[] args) {
        final int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Problem48().rotate(matrix);
    }
}
