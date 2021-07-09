package com.lvxiao.problem56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/12 3:21 下午
 */
public class Problem56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int i1;
            if (i > 0 && intervals[i][0] <= (i1 = res.get(res.size() - 1)[1])) {
                res.get(res.size() - 1)[1] = Math.max(intervals[i][1], i1);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Problem56().merge(new int[][] {{2, 3}, {4, 5}, {6, 7}, {1, 18}})));
    }
}
