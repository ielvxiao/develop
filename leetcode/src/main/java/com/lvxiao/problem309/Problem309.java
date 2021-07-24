package com.lvxiao.problem309;

import java.util.*;

/**
 * @author lvxiao
 * @date 2020/7/10
 */
public class Problem309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[][] dp = new int[prices.length][3];
        /*
        dp[i][0]:当前持有股票，可以是昨天持有的，也可以是今天刚买入的，昨天买，则昨天肯定不是冷冻期~~
        dp[i][1]:当前不持有股票且处于冷冻期（当天刚卖）。当天处于冷冻期，因为当天卖了股票
        dp[i][2]:当前不持有股票且不处于冷冻期。可能是昨天卖了，或者是昨天就不处于冷冻期
         */
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        int maxProfit = Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
        return maxProfit;
    }
}
