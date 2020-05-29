package com.lvxiao.problem394;

import java.util.Stack;

/**
 * @author lvxiao
 * @date 2020/5/28
 */
public class Problem394 {
    public static void main(String[] args) {
        System.out.println(new Problem394().decodeString("3[a2[c]]"));
    }
    public String decodeString(String s) {
        Stack<StringBuilder> sbStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if (c == '[') {
                sbStack.add(sb);
                numStack.add(num);
                sb = new StringBuilder();
                num = 0;
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                StringBuilder tmpSb = sbStack.pop();
                int n = numStack.pop();
                for (int i = 0; i < n; i++) {
                    tmpSb.append(sb);
                }
                sb = tmpSb;
            }
        }
        return sb.toString();
    }

}
