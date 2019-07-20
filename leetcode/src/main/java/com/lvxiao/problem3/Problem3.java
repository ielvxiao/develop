package com.lvxiao.problem3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-20 12:08
 */
public class Problem3 {

    /**
     * 存在超超时问题
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        List<Character> characterList = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (characterList.contains(s.charAt(i))) {
                res = Math.max(res, characterList.size());
                int index = characterList.indexOf(s.charAt(i));
                //截取重复位置之后的List
                characterList = characterList.subList(index + 1, characterList.size());
                characterList.add(s.charAt(i));
            } else {
                characterList.add(s.charAt(i));
                res = Math.max(res, characterList.size());
            }
        }
        return res;
    }

    /**
     * 滑动窗口解法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem3().lengthOfLongestSubstring("aaaaaa"));
    }
}
