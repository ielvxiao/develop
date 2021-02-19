package com.lvxiao.problem1004;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-02-19
 */
public class Problem1004 {
    public int longestOnes(int[] A, int K) {
        int len = A.length;
        int left = 0;
        int right = 0;
        int maxCount = 0;
        while (right < len) {
            if (A[right++] == 0) {
                maxCount++;
            }
            if (maxCount > K) {
                if (A[left++] == 0) {
                    maxCount--;
                }
            }
        }
        return right - left;
    }
}
