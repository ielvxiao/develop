package com.lvxiao.problem39;

import sun.security.provider.Sun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/20 2:33 下午
 */
public class Problem39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new LinkedList<>();
        }
        Arrays.sort(candidates);
         List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }


    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            //System.out.println(start);
            tmp_list.add(candidates[start]);
            //System.out.println(tmp_list);
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem39 problem39 = new Problem39();
        List<List<Integer>> list = problem39.combinationSum(new int[]{2, 3, 5}, 8);
        list.forEach(System.out::println);
    }
}
