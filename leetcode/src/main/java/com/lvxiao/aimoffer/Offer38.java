package com.lvxiao.aimoffer;

import java.util.*;

/**
 * @author lvxiao
 * @date 2020/6/16
 */
public class Offer38 {
    public static void main(String[] args) {
        Offer38 offer38 = new Offer38();
        for (String abc : offer38.permutation("abc")) {
            System.out.println(abc);
        }
    }
    char[] chars;
    List<String> list;
    public String[] permutation(String s) {
        if (s.length() == 0) {
            return new String[0];
        }
        chars = s.toCharArray();
        list = new ArrayList<>();
        dfs(0);
        return list.toArray(new String[0]);
    }

    void dfs(int i) {
        if (i == chars.length) {
            list.add(new String(chars));
        }
        Set<Character> set = new HashSet<>();
        for (int j = i; j < chars.length; j++) {
            if (!set.add(chars[j])) continue;
            swap(i, j);
            dfs(i + 1);
            swap(i, j);
            set.remove(j);
        }
    }

    void swap(int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
