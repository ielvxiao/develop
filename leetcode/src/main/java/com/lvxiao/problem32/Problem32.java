package com.lvxiao.problem32;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/18 4:16 下午
 */
public class Problem32 {

    /**
     * 使用栈
     *
     * @param s
     * @return
     */
    public int longestValidParenthesesStack(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    /**
     * 使用动态规划
     * 状态转移方程:
     * 如果括号为(:
     * 则dp[i]为0
     * 如果括号为):
     * 如果dp[i-1]为(:
     * dp[i]为dp[i-2]+2
     * 如果dp[i-1]为):
     * 如果dp[i-1]==0:
     * dp[i]=0
     * 如果dp[i-2*(dp[i-1])]为(:
     * dp[i]=dp[i-2*(dp[i-1])]+2
     *
     * @param s
     * @return
     */
    public int longestValidParenthesesDp(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else if (dp[i - 1] != 0 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 使用特殊方法，研究中
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length - 1, -1, -1, ')'));
    }

    private static int calc(char[] chars, int i, int flag, int end, char cTem) {
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (; i != end; i += flag) {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen++;
            if (sum < 0) {
                max = Math.max(max, validLen);
                sum = 0;
                currLen = 0;
                validLen = 0;
            } else if (sum == 0) {
                validLen = currLen;
            }
        }
        return Math.max(max, validLen);
    }

    public static void main(String[] args) {
        System.out.println(new Problem32().longestValidParenthesesDp(")(((((()())()()))()(()))("));
    }
}
