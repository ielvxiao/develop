package com.lvxiao.problem78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/19 5:31 下午
 */
public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return res;
        }
        backTracking(res, new ArrayList<>(), nums, 0);
        return res;
    }


    private void backTracking(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            backTracking(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Problem78().subsets(new int[]{1, 2, 3}).forEach(System.out::println);
    }
}
