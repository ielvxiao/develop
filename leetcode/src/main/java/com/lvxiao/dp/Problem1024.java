package com.lvxiao.dp;

/**
 * @author lvxiao
 * @date 2020/5/25
 */
public class Problem1024 {
    public static void main(String[] args) {
        System.out.println(new Problem1024().videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
    }
    public int videoStitching(int[][] clips, int T) {
        int start = 0;
        int end = 0;
        int count = 0;
        while (end < T) {
            int maxEnd = 0;
            for (int i = 0; i < clips.length; i++) {
                if (clips[i][0] <= start) {
                    maxEnd = Math.max(maxEnd, clips[i][1]);
                }
            }
            if (maxEnd <= end) {
                return -1;
            }
            count++;
            if (count > T) {
                return -1;
            }
            end = maxEnd;
            start = end;
        }
        return count;
    }
}
