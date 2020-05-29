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

    public int robNoDp(int[] nums) {
        int len = nums.length;
        if(len ==0)  return 0;
        if(len ==1)  return nums[0];
        int preTwo = nums[0];
        int preOne = nums[1];
        for (int i = 2; i < len; i++) {
            int tmp = preOne;
            preOne = Math.max(preTwo + nums[i], preOne);
            preTwo = Math.max(tmp, preTwo);
        }
        return Math.max(preOne,preTwo);
    }
    public static void main(String[] args) {
        System.out.println(new Problem198().robNoDp(new int[]{2,1,1,2}));
    }
}
