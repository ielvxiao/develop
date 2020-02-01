package com.lvxiao.problem77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/1 8:02 下午
 */
public class Problem77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combineHelper(1, n - k+1, k, new ArrayList<Integer>(), list);
        return list;
    }

    private void combineHelper(int start, int end, int k, List<Integer> tmp, List<List<Integer>> list) {
        if (k == 0) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= end; i++) {
            tmp.add(i);
            combineHelper(i + 1, end + 1, k - 1, tmp, list);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        new Problem77().combine(4, 2);
    }
}
