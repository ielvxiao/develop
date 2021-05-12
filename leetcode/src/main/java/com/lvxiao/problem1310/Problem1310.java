package com.lvxiao.problem1310;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-05-12
 */
public class Problem1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length + 1];
        for (int i = 1; i < xor.length; i++) {
            xor[i] = xor[i - 1] ^ arr[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = xor[queries[i][0]] ^ xor[queries[i][1] + 1];
        }
        return res;
    }
}
