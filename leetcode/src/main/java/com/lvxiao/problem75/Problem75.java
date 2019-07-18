package com.lvxiao.problem75;

import java.util.Arrays;

/**
 * 75. Sort Colors
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-16 21:56
 */
public class Problem75 {

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i]<v) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i]> v) {
                swap(arr, i, gt - 1);
                gt--;
            } else { // arr[i] == v
                i++;
            }
        }

        swap(arr, l, lt);

        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }


    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,7,10,3,9,11,12,13,14};
        System.out.println(arr);
    }
}
