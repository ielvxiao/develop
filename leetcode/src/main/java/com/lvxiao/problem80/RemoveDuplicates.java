package com.lvxiao.problem80;

/**
 * 80. Remove Duplicates from Sorted Array II
 * 看不懂什么意思。垃圾题
 * @author lvxiao
 * @version V1.0
 * @date 2019-05-30 23:09
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
