package com.lvxiao.problem5;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-11 21:30
 */
public class Problem5 {
    /**
     * 暴力解题法，没有任何优化
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp;
        for (int i = 0; i < s.length(); i++) {
            tmp = new StringBuilder(String.valueOf(s.charAt(i)));
            //做中间数
            int len = 1;
            while (i - len > -1 && i + len < s.length() && s.charAt(i - len) == s.charAt(i + len)) {
                tmp.insert(0, s.charAt(i - len));
                tmp.insert(tmp.length(), s.charAt(i + len));
                len++;
            }
            if (tmp.length() > sb.length()) {
                sb = tmp;
            }
            //和右边相同
            len = 1;
            tmp = new StringBuilder(String.valueOf(s.charAt(i)));
            while (i - len + 1 > -1 && i + len < s.length() && s.charAt(i - len + 1) == s.charAt(i + len)) {
                if (len != 1) {
                    tmp.insert(0, s.charAt(i - len + 1));
                }
                tmp.insert(tmp.length(), s.charAt(i + len));
                len++;
            }
            if (tmp.length() > sb.length()) {
                sb = tmp;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem5().longestPalindrome("tattarrattat"));
    }
}
