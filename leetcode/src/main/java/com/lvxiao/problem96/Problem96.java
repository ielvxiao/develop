package com.lvxiao.problem96;


/**
 * 96. Unique Binary Search Trees
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/4 4:15 下午
 */
public class Problem96 {
    /**
     * 对于1,2,3,4...n
     * 当1为根节点，则左侧有0个节点，右侧为n-1个节点。所以有f(0)*f(n-1)种情况
     * 故对于输入n则会有f(n) = f(0)f(n-1) + f(1)f(n-2).... + f(n-2)f(1) + f(n-1)f(0)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int num = 0;
            for (int j = 0; j < i; j++) {
                num += dp[j] * dp[i - 1 - j];
            }
            dp[i] = num;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Problem96().numTrees(3));
    }
}
