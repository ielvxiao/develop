package com.lvxiao.problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-15 22:24
 */
public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //进行排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //循环加
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    R--;
                    L++;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return result;
    }

    private void quickSort(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        partaion(nums, head, tail);
    }

    private void partaion(int[] nums, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int mid = (head + tail) / 2;
        int i = head;
        int j = tail;
        while (i < j) {
            while (nums[i] < nums[mid]) {
                i++;
            }
            while (nums[j] > nums[mid]) {
                j--;
            }
            if (i == j) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        partaion(nums,i+1,tail);
        partaion(nums, head, tail - 1);
    }

    public static void main(String[] args) {

    }
}
