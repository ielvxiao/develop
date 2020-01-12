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
        List<int[]> arr = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length; i++) {
            if (arr.size() == 0 || arr.get(arr.size() - 1)[1] < intervals[i][0]) {
                arr.add(intervals[i]);
            } else if (arr.get(arr.size() - 1)[1] >= intervals[i][0] && arr.get(arr.size() - 1)[1] < intervals[i][1]) {
                arr.get(arr.size() - 1)[1] = intervals[i][1];
            }
        }
        return arr.toArray(new int[arr.size()][]);
    }

    public static void main(String[] args) {
        new Problem56().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
