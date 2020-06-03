package com.lvxiao.aimoffer;

/**
 * @author lvxiao
 * @date 2020/6/3
 */
public class Problem64 {
    public int sumNums(int n) {
        int ans = 0, A = n, B = n + 1;
        while (B > 0) {
            if ((B & 1) > 0) {
                ans += A;
            }
            A <<= 1;
            B >>= 1;
        }
        return ans >> 1;
    }
}
