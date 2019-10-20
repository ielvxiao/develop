package com.lvxiao.problem70;

/**
 * 70. Climbing Stairs
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/20 10:59 下午
 */
public class Problem70 {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
