package com.lvxiao.problem46;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * 使用回溯
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/7 3:05 下午
 */
public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(nums, new ArrayList<>(), res);
        return res;
    }


    private void backTracking(int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            backTracking(nums, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    //begin 一种比较好的方式，执行时间快，内存消耗少
    public List<List<Integer>> permute1(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(result, num, 0);
        return result;
    }

    private void permute(List<List<Integer>> result, int[] array, int start) {
        if (start >= array.length) {
            List<Integer> current = new ArrayList<Integer>();
            for (int a : array) {
                current.add(a);
            }
            result.add(current);
        } else {
            for (int i=start; i<array.length; i++) {
                swap(array, start, i);
                permute(result, array, start+1);
                swap(array, start, i);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //end
}
