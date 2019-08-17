package com.lvxiao.problem28;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-08-17 21:05
 */
public class Problem28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.equals("") || haystack.equals(needle)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int k = i;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1 && haystack.charAt(k) == needle.charAt(j)) {
                    return i;
                }
                k++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem28().strStr("mississippi", "issi"));
    }
}
