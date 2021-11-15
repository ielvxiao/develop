package com.lvxiao.problem38;

/**
 * @author hongqi
 * @date 2021/11/14
 */
public class Problem38 {

    public static void main(String[] args) {
        new Problem38().countAndSay(4);
    }
    public String countAndSay(int n) {
        return recursion("1", n - 1);
    }

    private String recursion(String s, int step) {
        if(step==0) return s;
        StringBuilder sb = new StringBuilder();
        int len=1;
        char c = s.charAt(0);
        sb.append(c);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                len++;
            } else {
                sb.append(len);
                sb.append(c);
                c = s.charAt(i);
                len = 1;
            }
        }
        sb.append(len);
        sb.append(c);
        return recursion(sb.toString(), --step);
    }
}
