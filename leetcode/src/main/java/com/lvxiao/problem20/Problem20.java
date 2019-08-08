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
        /**
         * 构建比较map，方便获取
         */
        Map<Character, Character> matchMap = new HashMap<Character, Character>() {
            {
                put(']', '[');
                {
                    put(')', '(');
                    {
                        put('}', '{');
                    }
                }
            }
        };
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (matchMap.containsKey(c) && (stack.empty() || !stack.pop().equals(matchMap.get(c)))) {
                return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Problem20().isValid("{[]}"));
    }
}