package com.lvxiao.aimoffer;

/**
 * @author lvxiao
 * @date 2020/6/9
 */
public class Problem46 {
    public int translateNum(int num) {
        if (num < 10) return 1;
        int[] dp = new int[33];
        dp[0] = 1;
        dp[1] = 1;
        int pre = num % 10;
        num /= 10;
        for (int i = 2; i < 33; i++) {
            if (num == 0) {
                return dp[--i];
            }
            int tmp = num % 10;
            int db = 10 * tmp + pre;
            dp[i] = db < 26 && db > 9 ? dp[i - 1] + dp[i - 2] : dp[i - 1];
            pre = tmp;
            num /= 10;
        }
        return dp[32];
    }

    public static void main(String[] args) {
        System.out.println(new Problem46().translateNum(Integer.MAX_VALUE));
    }
}
