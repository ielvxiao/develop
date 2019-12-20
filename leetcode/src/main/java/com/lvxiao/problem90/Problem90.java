package com.lvxiao.problem90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/20 10:44 上午
 */
public class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backTracking(res, new ArrayList<>(), nums, 0);
        return res;
    }


    private void backTracking(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tmp.add(nums[i]);
            backTracking(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Problem90().subsetsWithDup(new int[]{1, 2, 2}).forEach(System.out::println);
    }
}
