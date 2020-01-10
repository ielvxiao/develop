package com.lvxiao.problem55;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/10 6:36 下午
 */
public class Problem55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int tmp = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > tmp) {
                tmp = 0;
            } else {
                tmp++;
            }
        }
        return tmp == 0;
    }
}
