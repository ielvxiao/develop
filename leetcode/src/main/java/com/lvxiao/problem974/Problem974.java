package com.lvxiao.problem974;

/**
 * @author lvxiao
 * @date 2020/5/27
 */
public class Problem974 {
    public static void main(String[] args) {
        System.out.println(new Problem974().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0, counter = 0;
        int[] remainders = new int[K];
        remainders[0] = 1;

        for (int a : A) {
            sum += a;
            int remainder = Math.floorMod(sum, K);
            counter += remainders[remainder];
            ++remainders[remainder];
        }

        return counter;
    }
}
