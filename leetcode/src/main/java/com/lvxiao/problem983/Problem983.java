package com.lvxiao.problem983;

/**
 * @author lvxiao
 * @date 2020/5/6
 */
public class Problem983 {
    /**
     * dp[ n ]=min( dp[ n-1 ] + cost[ 0 ] , dp[ n-7 ] + cost[ 1 ] , dp[ n-30 ] + cost[ 2 ] )
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        dp[0] = 0;
        int index = 0;
        for (int i = 1; i < dp.length; i++) {
            if (i == days[index]) {
                index++;
                int one = dp[i - 1] + costs[0];
                int seven = i < 7 ? dp[i - 1] +costs[1] : dp[i - 7] + costs[1];
                int eleven = i < 30 ? dp[i - 1] +costs[2] : dp[i - 30] + costs[2];
                dp[i] = Math.min(one, Math.min(seven, eleven));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    /*
    [1,4,6,7,8,20]
    [7,2,15]
     */
    public static void main(String[] args) {
        Problem983 problem983 = new Problem983();
        int i = problem983.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{7, 2, 15});
        System.out.println(i);
    }

}
