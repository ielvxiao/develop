package com.lvxiao.problem1442;

import java.util.stream.Stream;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-05-18
 */
public class Problem1442 {
    /**
     * 这道题很简单，其实就是a=b a^b=0则如果a[i]^....^a[j]=0
     * 则看a[i]-a[j]之间有几种组合。其实就是有j-i中组合
     */
    public int countTriplets(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int tmp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                tmp ^= arr[j];
                if (tmp == 0) {
                    res += j - i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1442().countTriplets(new int[]{1,3,5,7,9}));
    }
}
