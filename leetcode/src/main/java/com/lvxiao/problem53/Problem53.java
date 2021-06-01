package com.lvxiao.problem53;

/**
 * 53. Maximum Subarray
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-21 16:43
 */
public class Problem53 {
    public int maxSubArray(int[] nums) {
        long max = Integer.MIN_VALUE;
        long result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                result = Math.max(result, num);
                max = Math.max(max + num, num);
            } else {
                max = Math.max(max + num, num);
                result = Math.max(result, max);
            }
        }
        return (int) result;
    }

    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
