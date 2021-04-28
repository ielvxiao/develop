package com.lvxiao.problem1011;

/**
 * @author lvxiao
 * @date 2021/4/26
 */
public class Problem1011 {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int need = 1;
            int cur = 0;
            for (int weight : weights) {
                if (cur >= mid) {
                    need++;
                    cur = 0;
                } else {
                    cur += weight;
                }
            }
            if (need > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1011().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3));
    }
}
