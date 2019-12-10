package com.lvxiao.problem47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/7 5:00 下午
 */
public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracing(nums, new ArrayList<>(), list, used);
        return list;
    }

    private void backTracing(int[] nums, List<Integer> tmp, List<List<Integer>> list, boolean[] used) {
        if (tmp.size() == nums.length) {
            list.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue;
                tmp.add(nums[i]);
                used[i] = true;
                backTracing(nums, tmp, list, used);
                used[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Problem47().permuteUnique(new int[]{1, 1, 2});
        list.forEach(System.out::println);
    }
}
