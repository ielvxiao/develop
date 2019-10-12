package com.lvxiao.problem64;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/12 4:06 下午
 */
public class Problem64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j];
                if (i - 1 < 0 && j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                } else if (j - 1 < 0 && i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
