package com.lvxiao.aimoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lvxiao
 * @date 2020/6/28
 */
public class Offer48 {
    public static void main(String[] args) {
        System.out.println(new Offer48().lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)   return 0;
        int max = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (list.contains(c)) {
                list.remove(0);
                continue;
            }
            list.add(c);
            max = Math.max(max, list.size());
            i++;
        }
        return max;
    }
}
