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
        int len = 0;
        for (int num : nums) {
            int low=0,hi = len;
            int idx = Arrays.binarySearch(tails, 0, len, num);
            idx = idx < 0 ? -idx - 1 : idx;
            tails[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7};
        System.out.println(Arrays.binarySearch(arr, 0));
    }
}
