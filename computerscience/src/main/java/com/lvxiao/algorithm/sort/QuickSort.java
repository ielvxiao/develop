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
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,7,10,3,9,11,12,13,14};
        qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
