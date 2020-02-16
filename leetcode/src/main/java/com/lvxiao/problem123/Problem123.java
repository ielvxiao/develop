package com.lvxiao.problem123;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/16 2:29 下午
 */
public class Problem123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][5];
        /*
        j的5中状态
        j=0：不进行任何操作
        j=1：第一次买入
        j=2：第一次卖出
        j=3：第二次买入
        j=4：第二次卖出
         */
        dp[0][1] = -prices[0];
        dp[0][3] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            //以下计算为主逻辑，可以考虑将dp声明为一位数组~~
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], prices[i] + dp[i - 1][1]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i-1][2]-prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], prices[i] + dp[i - 1][3]);
        }
        return Math.max(0, Math.max(dp[prices.length - 1][4], dp[prices.length - 1][2]));
    }

    public int maxProfit1D(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[5];
        /*
        j的5中状态
        j=0：不进行任何操作
        j=1：第一次买入
        j=2：第一次卖出
        j=3：第二次买入
        j=4：第二次卖出
         */
        dp[1] = -prices[0];
        dp[3] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            //以下计算为主逻辑，可以考虑将dp声明为一位数组~~
            dp[1] = Math.max(dp[1], -prices[i]);
            dp[2] = Math.max(dp[2], prices[i] + dp[1]);
            dp[3] = Math.max(dp[3], dp[2]-prices[i]);
            dp[4] = Math.max(dp[4], prices[i] + dp[3]);
        }
        return Math.max(0, Math.max(dp[4], dp[2]));
    }

    public static void main(String[] args) {
        System.out.println(new Problem123().maxProfit1D(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
