package com.lvxiao.problem287;

/**
 * @author lvxiao
 * @date 2020/5/26
 */
public class Problem287 {
    public int findDuplicate(int[] nums) {
        /* 抽屉原理*/
        int low=0;
        int fast = 0;
        do {
            low = nums[low];
            fast = nums[nums[fast]];
        } while (low != fast);
        low = 0;
        while (low != fast) {
            low = nums[low];
            fast = nums[fast];
        }
        return low;
    }
}
