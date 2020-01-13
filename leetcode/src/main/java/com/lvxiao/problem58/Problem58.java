package com.lvxiao.problem58;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/13 10:54 上午
 */
public class Problem58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && res > 0) {
                return res;
            } else if (s.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem58().lengthOfLastWord("a "));
    }
}
