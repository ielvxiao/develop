package com.lvxiao.problem53;

/**
 * 53. Maximum Subarray
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-21 16:43
 */
public class Problem53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            throw new RuntimeException("有病？？");
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
                res = Math.max(res, dp[i]);
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
