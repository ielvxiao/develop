package com.lvxiao.problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-19 22:26
 */
public class Problem1 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0;i<nums.length-1;i++){
            res[0]=i;
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }

    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Problem1().twoSumMap(new int[]{3, 2, 4}, 6);
    }
}
