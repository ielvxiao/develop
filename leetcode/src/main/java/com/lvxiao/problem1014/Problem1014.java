package com.lvxiao.problem1014;


/**
 * @author lvxiao
 * @date 2020/6/17
 */
public class Problem1014 {
    public static void main(String[] args) {
        System.out.println(new Problem1014().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    public int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE, left = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i] -i + left);
            left = Math.max(left, A[i] + i);
        }
        return max;
    }
}
