package com.lvxiao.problem67;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/28 8:50 下午
 */
public class Problem67 {
    /**
     * 自己的解法，感觉太复杂
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        String tmp = a.length() >= b.length() ? a : b;
        b = a.length() < b.length() ? a : b;
        a = tmp;
        int pre = 0;
        int aLen = a.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = b.length() - 1; i > -1; i--) {
            int sum = Character.digit(b.charAt(i), 10) + Character.digit(a.charAt(aLen--), 10) + pre;
            if (sum >= 2) {
                pre = 1;
                sb.insert(0, sum - 2);
            } else {
                pre = 0;
                sb.insert(0, sum);
            }
        }
        if (aLen >= 0 && pre == 0) {
            sb.insert(0, a.substring(0, aLen + 1));
        } else if (pre == 1) {
            for (int i = aLen; i >= 0; i--) {
                int sum = Character.digit(a.charAt(i),10) + pre;
                if (sum == 2) {
                    sb.insert(0, 0);
                    pre = 1;
                } else {
                    sb.insert(0, 1);
                    sb.insert(0, a.substring(0, i));
                    return sb.toString();
                }
            }
        }
        if (pre == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem67().addBinary("101111", "10"));
    }
}
