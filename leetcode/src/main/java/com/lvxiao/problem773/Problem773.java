package com.lvxiao.problem773;

import java.util.*;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-06-26
 */
public class Problem773 {

    private int[][] neighbor = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    /**
     * [[1,2,3],[4,5,0]]
     */
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(ints[j]);
            }
        }
        if (sb.toString().equals("123450")) {
            return 0;
        }
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(sb.toString());
        seen.add(sb.toString());
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                final String poll = queue.poll();
                for (String s : get(poll)) {
                    if (s.equals("123450")) {
                        return step;
                    }
                    if (seen.add(s)) {
                        queue.add(s);
                    }
                }
            }
        }
        return -1;
    }

    private Set<String> get(String status) {
        Set<String> set = new HashSet<>();
        final char[] chars = status.toCharArray();
        final int i = status.indexOf("0");
        final int[] ints = neighbor[i];
        for (int index : ints) {
            swap(chars, i, index);
            set.add(new String(chars));
            swap(chars, i, index);
        }
        return set;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
