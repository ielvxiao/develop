package com.lvxiao;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-08-01
 */
public class TopK {

    public static void main(String[] args) {
        new TopK().topK(new int[]{1, 34, 5, 23, 4, 7, 123, 561}, 3);
    }

    private void topK(int[] nums, int k) {
        //大顶堆
        final int length = nums.length;
        int begin = (nums.length - 2) / 2;
        for (int i = begin; i >= 0; i--) {
            heapHelper(nums, i, length);
        }
        List<Integer> list = new LinkedList<>();
        //下沉
        for (int i = 0; i < k; i++) {
            list.add(nums[0]);
            swap(nums, 0, length - 1 - i);
            heapHelper(nums, 0, nums.length - i - 1);
        }
        list.forEach(System.out::println);
    }

    private void heapHelper(int[] nums, int index, int len) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left >= len) {
            return;
        }
        int max = left;
        if (right < nums.length && nums[right] > nums[max]) {
            max = right;
        }
        if (nums[max] > nums[index]) {
            swap(nums, max, index);
            heapHelper(nums, max, len);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
