package com.lvxiao.problem912;

import java.util.Arrays;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-05-29
 */
public class Problem912 {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int s = l, e = r;
        int pave = nums[s];
        while (s < e) {
            while (s < e && nums[e] > pave) {
                e--;
            }
            if (s < e) {
                nums[s] = nums[e];
            }
            while (s < e && nums[s] <= pave) {
                s++;
            }
            if (s < e) {
                nums[e] = nums[s];
            }
        }
        nums[s] = pave;
        sort(nums, l, s - 1);
        sort(nums, s + 1, r);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 2, 3, 1};
        Problem912 problem912 = new Problem912();
        System.out.println(Arrays.toString(problem912.sortArray(arr)));
    }
}
