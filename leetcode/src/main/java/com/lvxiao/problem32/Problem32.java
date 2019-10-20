package com.lvxiao.problem32;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/18 4:16 下午
 */
public class Problem32 {
    public int longestValidParentheses(String s) {
        int res = 0;
        if (s.isEmpty()) {
            return res;
        }
        boolean left = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left = true;
            } else if (left && s.charAt(i) == ')') {
                left = false;
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
                left = false;
            }
        }
        return Math.max(res, count) * 2;
    }

    public static void main(String[] args) {
        System.out.println(new Problem32().longestValidParentheses(")()())"));
    }
}
