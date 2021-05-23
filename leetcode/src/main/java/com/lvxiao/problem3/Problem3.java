package com.lvxiao.problem3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-20 12:08
 */
public class Problem3 {

    /**
     * 存在超超时问题
     *
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
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 滑动窗口优化，因为滑动窗口寻找窗口内字符串的时候
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] hash = new int[128];  //每个字符对应的位置
        int res = 0;
        for (int j = 0, i = 0; j < s.length(); j++) {
            i = Math.max(i, hash[s.charAt(j)]);
            res = Math.max(j - i + 1, res);
            hash[s.charAt(j)] = j + 1;//index从1开始，防止默认0出问题
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem3().lengthOfLongestSubstring2("abcabcbb"));
    }
}
