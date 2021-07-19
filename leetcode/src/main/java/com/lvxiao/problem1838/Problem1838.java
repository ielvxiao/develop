package com.lvxiao.problem1838;

import java.util.Arrays;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-19
 */
public class Problem1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        long total = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            total += (long) (nums[i] - nums[i - 1]) * (i - l);
            if (total > k) {
                total -= nums[i] - nums[l];
                l++;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}
