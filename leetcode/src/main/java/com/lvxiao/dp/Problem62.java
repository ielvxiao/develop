package com.lvxiao.dp;

import com.lvxiao.problem24.Problem24;

import java.util.Arrays;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-08-11 13:24
 */
public class Problem62 {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m - 1][n - 1];
    }

    /**
     * [1, 1, 1, 1]
     * [1, 2, 3, 4]
     * [1, 3, 6, 10]
     * [1, 4, 10, 20]
     * [1, 5, 15, 35]
     * 找规律
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsOp(int m, int n) {
        int[] res = new int[m];
        Arrays.fill(res,1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                res[j] = res[j - 1] + res[j];
            }

        }
        return res[m - 1];
    }
    public static void main(String[] args) {
        System.out.println(new Problem62().uniquePathsOp(4, 5));
    }
}
