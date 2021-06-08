package com.lvxiao.problem20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * @author lvxiao
 * @date 2019/8/2
 */
public class Problem20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem20().isValid("{[]}"));
    }
}