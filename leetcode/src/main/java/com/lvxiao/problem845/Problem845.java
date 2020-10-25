package com.lvxiao.problem845;

/**
 * @author lvxiao
 * @date 2020/10/25
 */
public class Problem845 {
    public static void main(String[] args) {
        System.out.println(new Problem845().longestMountain(new int[]{8, 3, 7, 3, 4, 10, 1, 1, 2, 8}));
    }
    public int longestMountain(int[] A) {
        int res = 0, down = 0, up = 0;
        boolean isUp = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (!isUp) {
                    if (up > 0 && down > 0) {
                        res = Math.max(res, down + up + 1);
                    }
                    up = 0;
                    down = 0;
                }
                isUp = true;
                up++;
            } else if (A[i] < A[i - 1]) {
                down++;
                isUp = false;
            } else {
                if (!isUp && up > 0 && down > 0) {
                    int size = Math.min(down, up);
                    res = Math.max(res, down + up + 1);
                }
                up = 0;
                down = 0;
            }
        }
        if (up > 0 && down > 0) {
            res = Math.max(res, down + up + 1);
        }
        return res;
    }
}
