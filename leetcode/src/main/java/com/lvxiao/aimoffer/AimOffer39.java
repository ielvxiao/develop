package com.lvxiao.aimoffer;

/**
 * @author lvxiao
 * @date 2020/6/17
 */
public class AimOffer39 {
    public int majorityElement(int[] nums) {
        int vote=0;
        int i = 0;
        for (int num : nums) {
            if (vote==0) {
                i = num;
            }
            vote += i == num ? 1 : -1;
        }
        return i;
    }
}
