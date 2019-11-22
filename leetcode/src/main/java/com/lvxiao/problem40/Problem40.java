package com.lvxiao.problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/22 2:17 下午
 */
public class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (!res.contains(tmp_list)) {
                res.add(new ArrayList<>(tmp_list));
            }
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            //System.out.println(start);
            tmp_list.add(candidates[start]);
            //System.out.println(tmp_list);
            backtrack(candidates, target - candidates[start], res, start + 1, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem40().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        lists.forEach(System.out::println);
    }
}
