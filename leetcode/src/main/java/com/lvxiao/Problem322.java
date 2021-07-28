package com.lvxiao;

import java.util.Arrays;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-28
 */
public class Problem322 {

    public static void main(String[] args) {
        System.out.println(new Problem322().coinChange(new int[] {186, 419, 83, 408}, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }



}
