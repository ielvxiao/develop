package com.lvxiao.problem198;

/**
 * 198. House Robber
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/24 11:53 下午
 */
public class Problem198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem198().rob(new int[]{3,1,1,2}));
    }
}
