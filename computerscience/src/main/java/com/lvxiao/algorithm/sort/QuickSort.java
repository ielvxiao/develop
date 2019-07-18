package com.lvxiao.algorithm.sort;

import java.util.Arrays;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-07 21:51
 */
public class QuickSort {


    /**
     * 快速排序
     * @param arr
     * @param head
     * @param tail
     */
    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    public static void exchange(int[] sum, int i, int j) {
        int temp = sum[i];
        sum[i] = sum[j];
        sum[j] = temp;
    }

    /**
     * 三路快排
     * @param nums
     * @param top
     * @param tail
     */
    public static void quickSort3(int[] nums, int top, int tail) {
        if (top >= tail) {
            return;
        }
        int lt = top, gt = tail, i = top + 1;
        int pivot = nums[top];
        while (i <= gt) {
            if (nums[i] > pivot) {
                exchange(nums, i, gt--);
            } else if (nums[i] < pivot) {
                exchange(nums, i++, lt++);
            } else {
                i++;
            }
        }
        quickSort3(nums, top, lt - 1);
        quickSort3(nums, gt + 1, tail);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,7,10,3,9,11,12,13,14};
        quickSort3(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
