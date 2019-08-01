package com.lvxiao.problem14;

/**
 * 14. Longest Common Prefix
 * @author lvxiao
 * @version V1.0
 * @date 2019-08-01 23:24
 */
public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //最长公共子串，在第一个元素上的终止位置
        int index = strs[0].length();
        if (index == 0) {
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            if (strs[i] == null || !strs[i].startsWith(strs[i - 1].substring(0, 1))) {
                return "";
            }
            for (int j = index; j > 0; j--) {
                if (strs[i].startsWith(strs[i - 1].substring(0, j))) {
                    index = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, index);
    }

    public static void main(String[] args) {
        System.out.println(new Problem14().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
