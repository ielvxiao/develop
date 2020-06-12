package com.lvxiao.problem15;

import java.lang.reflect.Array;
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
    public static void main(String[] args) {
        System.out.println(new Problem15().threeSum(new int[]{0,0,0,0}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        //进行排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            int first = nums[i];
            if (i > 0 && first == nums[i - 1]) {
                continue;
            }
            if (first > 0) {
                return result;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + first==0) {
                    result.add(Arrays.asList(first, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                while (left < right && nums[left] + nums[right] + first < 0) {
                    left++;
                }
                while (left < right && nums[left] + nums[right] + first > 0) {
                    right--;
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


}
