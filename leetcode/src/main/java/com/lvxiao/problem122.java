package com.lvxiao;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-24
 */
public class problem122 {
    public static void main(String[] args) {
        System.out.println(new problem122().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //只要赔钱之前卖掉就行，不赔钱就一直持有
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
