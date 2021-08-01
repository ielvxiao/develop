package com.lvxiao;

import java.util.Arrays;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-27
 */
public class problem518 {

    public static void main(String[] args) {
        System.out.println(new problem518().change(5, new int[]{1, 2, 5}));
    }
    int res = 0;

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        helper(amount, coins, 0);
        return res;
    }

    private void helper(int amount, int[] coins, int index) {
        if (amount == 0 || index == coins.length) {
            res++;
        }
        for (int i = index; i < coins.length; i++) {
            int tmp = amount;
            while (tmp >= coins[i]) {
                tmp -= coins[i];
                helper(tmp, coins, index + 1);
            }
        }
    }
}
