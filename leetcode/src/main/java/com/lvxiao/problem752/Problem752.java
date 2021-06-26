package com.lvxiao.problem752;

import java.util.*;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-06-26
 */
public class Problem752 {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000")) {
            return -1;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> toVisit = new LinkedList<>();
        toVisit.add("0000");
        int step = 0;
        while (!toVisit.isEmpty()) {
            step++;
            final int size = toVisit.size();
            for (int i = 0; i < size; i++) {
                final String poll = toVisit.poll();
                visited.add(poll);
                for (String s : getNextStepString(poll)) {
                    if (s.equals(target)) {
                        return step;
                    }
                    if (!set.contains(s) && !visited.contains(s)) {
                        visited.add(s);
                        toVisit.add(s);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNextStepString(String s) {
        List<String> list = new ArrayList<>();
        final char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            char up = c == '9' ? '0' : (char) (c + 1);
            char down = c == '0' ? '9' : (char) (c - 1);
            chars[i] = up;
            list.add(new String(chars));
            chars[i] = down;
            list.add(new String(chars));
            chars[i] = c;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Problem752().openLock(new String[]{"8888"}, "0009"));
    }
}
