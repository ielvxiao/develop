package com.lvxiao.problem300;

import java.util.Arrays;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/3/14 2:34 下午
 */
public class Problem300 {

    public int lengthOfLIS(int[] nums) {
        //保存最长子序列的tail
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[len - 1]) {
                tails[len++] = nums[i];
            } else {
                int start = 0;
                int end = len - 1;
                while (start <= end) {
                    int mid = (start + end) >>> 1;
                    if (tails[mid] > nums[i]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                tails[start] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Problem300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
