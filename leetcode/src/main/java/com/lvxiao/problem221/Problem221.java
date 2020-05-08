package com.lvxiao.problem221;

/**
 * @author lvxiao
 * @date 2020/5/8
 */
public class Problem221 {

    public int maximalSquare(char[][] matrix) {
        /**
         dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长, 则递推式为:
         dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
         **/
        int m = matrix.length;
        if(m < 1) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max*max;
    }

    /**
     * 优化版，因为dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]); 只会用到上一行和上一列的值，所以不用存储那么多的数据就行
     * @param matrix
     * @return
     */
    public int maximalSquareOp(char[][] matrix) {
        int m = matrix.length;
        if(m < 1) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[]pre = new int[n+1];
        int[]cur = new int[n+1];

        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(matrix[i-1][j-1] == '1') {
                    cur[j] = 1 + Math.min(pre[j-1], Math.min(pre[j], cur[j-1]));
                    max = Math.max(max, cur[j]);
                }
                pre[j - 1] = cur[j - 1];// 上一行的j-1位置用不到了，此时就可以替换为本行的结果，为下一行的运算做准备。
                cur[j - 1] = 0;// 本行用不到的结果置0，为下一行做准备。
            }
            pre[n] = cur[n];
            cur[n] = 0;
        }
        return max*max;
    }
}
