package com.lvxiao.problem131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/20 2:22 下午
 */
public class Problem131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTracing(s, res, new ArrayList<>(), 0);
        return res;
    }

    private void backTracing(String s,List<List<String>> res, List<String> tmp, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tmp.add(s.substring(start, i + 1));
                    backTracing(s, res, tmp, i + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new Problem131().partition("aab");
        System.out.println(res);
    }
}
