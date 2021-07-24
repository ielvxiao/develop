package com.lvxiao;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-24
 */
public class problem714 {
    public static void main(String[] args) {
        System.out.println(new problem714().maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        /*
        dp[i][0]:当天持有股票
        dp[i][1]:当天未持有
         */
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0] - fee);
        }
        return dp[len - 1][1];
    }
}
