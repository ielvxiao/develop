package com.lvxiao.problem1734;

/**
 * @author lvxiao
 * @date 2021/5/12
 */
public class Problem1734 {
    public int[] decode(int[] encoded) {
        int len = encoded.length;
        int total = 0;
        for (int i = 1; i <= len + 1; i++) {
            total ^= i;
        }
        int odd = 0;
        for (int i = 0; i < len; i = i + 2) {
            odd ^= encoded[i];
        }
        int[] decode = new int[len + 1];
        decode[len] = total ^ odd;
        for (int i = len - 1; i >= 0; i--) {
            decode[i] = encoded[i] ^ decode[i + 1];
        }
        return decode;
    }
}
