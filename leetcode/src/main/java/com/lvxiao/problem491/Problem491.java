package com.lvxiao.problem491;

import java.util.*;

/**
 * @author lvxiao
 * @date 2020/8/25
 */
public class Problem491 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null) {
            return null;
        }
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }

    public void dfs(int curIndex, int preValue, int[] nums) {
        if (curIndex>= nums.length){
            if (temp.size()>=2) res.add(new ArrayList<>(temp));
            return;
        }
        if (nums[curIndex] >= preValue) {
            temp.add(nums[curIndex]);
            dfs(curIndex+1, nums[curIndex], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[curIndex] != preValue) {
            dfs(curIndex + 1, preValue, nums);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem491().findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
