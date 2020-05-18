package com.lvxiao.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvxiao
 * @date 2020/5/18
 */
public class Problem523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int summ = sum[end] - sum[start] + nums[start];
                if (summ == k || (k != 0 && summ % k == 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 使用hashmap保存[0,i]的总和，如何之前含有这个值，且跨度大于1则返回
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum2(int[] nums, int k){
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 键为 preSum % k, 值为索引，当然要特殊处理k == 0的情况
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = k == 0 ? sum : sum % k;
            if(map.containsKey(temp)){ // 出现相同的键，如果子数组长度少于2， 不需要更新值。
                if(i - map.get(temp) > 1) // 子数组要求长度至少为2。
                    return true;
                continue;
            }
            map.put(temp, i);
        }
        return false;
    }
}
