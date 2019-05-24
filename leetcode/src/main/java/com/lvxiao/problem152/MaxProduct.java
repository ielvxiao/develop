package com.lvxiao.problem152;

import java.util.*;

/**
 * 152. Maximum Product Subarray
 *
 * @author lvxiao
 * @date 2019/5/23
 */
public class MaxProduct {

    /**
     * 第一次写的方法，超时。
     * @param nums
     * @return
     */
    public int maxProductOne(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result = Integer.MIN_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i + "", nums[i]);
            if (result < nums[i]) {
                result = nums[i];
            }
            for (int j = i - 1; j >= 0; j--) {
                int tmpi;
                if (j == i - 1) {
                    tmpi = map.get(j + "") * nums[i];
                } else {
                    tmpi = map.get(j + "_" + (i - 1)) * nums[i];
                }
                if (result < tmpi) {
                    result = tmpi;
                }
                map.put(j + "_" + i, tmpi);
            }
        }
        return result;
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            //这个隐形的保证了连续
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{2,3,-2,4}));
    }
}
