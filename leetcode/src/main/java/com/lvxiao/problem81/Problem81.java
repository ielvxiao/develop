package com.lvxiao.problem81;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/5 12:54 下午
 */
public class Problem81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = nums[0];
        int end = nums[nums.length - 1];
        if (target == start || target == end) {
            return true;
        }
        if (end > start && target < start) {
            return false;
        }
        int head = 0;
        int tail = nums.length - 1;
        if (target < start) {
            for (int i = tail; i > head; i--) {
                if (nums[i] > end || nums[i] < target) {
                    return false;
                } else if (nums[i] == target) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < tail; i++) {
                if (nums[i] < start || nums[i] > target) {
                    return false;
                } else if (nums[i] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem81().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }
}
