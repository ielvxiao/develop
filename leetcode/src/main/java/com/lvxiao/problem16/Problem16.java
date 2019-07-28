package com.lvxiao.problem16;


import java.util.Arrays;

/**
 * 16. 3Sum Closest
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-28 14:26
 */
public class Problem16 {
    /**
     * 利用15的思路进行解题
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        //进行排序
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        //循环加
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    R--;
                } else {
                    L++;
                }
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = Math.abs(target - sum);
                    res = sum;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        int target = 0;
        Problem16 Problem16 = new Problem16();
        int threeSumClosest = Problem16.threeSumClosest(nums, target);
        System.out.println(threeSumClosest);
    }
}
