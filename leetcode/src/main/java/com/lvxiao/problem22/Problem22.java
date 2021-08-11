package com.lvxiao.problem22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * @author lvxiao
 * @date 2019/8/2
 */
public class Problem22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisHelper(res, "", 0, 0, n);
        return res;
    }

    private void generateParenthesisHelper(List<String> res, String s, int left, int right, int n) {
        if (right == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            generateParenthesisHelper(res, s + "(", left + 1, right, n);
        }
        if (right < left) {
            generateParenthesisHelper(res, s + ")", left, right + 1, n);
        }
    }

    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, new StringBuilder(), n, 0, 0);
        return list;
    }

    private void backTrack(List<String> list, StringBuilder sb, int n, int left, int right) {
        if (sb.length() == n * 2) {
            list.add(sb.toString());
        }

        if (left < n) {
            sb.append('(');
            backTrack(list, sb, n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            backTrack(list, sb, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        List<String> list = new Problem22().generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
