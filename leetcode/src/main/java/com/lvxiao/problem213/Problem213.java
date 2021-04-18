package com.lvxiao.problem213;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-04-18
 */
public class Problem213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = nums[start+1];
        for (int i = start + 2; i <= end; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }

}
