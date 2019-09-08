package com.lvxiao;

import java.util.Arrays;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/8 11:05 下午
 */
public class Problem31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int i = nums.length - 2;
        //从后向前寻找第一个不是倒序的节点
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //如果不存在这个节点，则重新排序
        if (i < 0) {
            i = 0;
            reverse(nums, i);
        } else {
            //从后向前寻找第一个比次节点小的节点
            int tail = nums.length - 1;
            while (nums[tail] <= nums[i]) {
                tail--;
            }
            //交换
            swap(nums, i, tail);
            //交换万后i后边的节点重新排列成最小值，则为满足条件解
            reverse(nums, i + 1);
        }
    }

    private void reverse(int[] nums, int i) {
        int tail = nums.length - 1;
        while (i < tail) {
            swap(nums, i, tail);
            i++;
            tail--;
        }
    }

    private void swap(int[] nums, int i, int tail) {
        int tmp = nums[tail];
        nums[tail] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        Problem31 problem31 = new Problem31();
        int[] ints = {2,3,1};
        problem31.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }
}
