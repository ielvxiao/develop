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
     */
    public static void   qSort(int[] arr,int s,int e){
        int l = s, r = e;
        if(l < r){
            int temp = arr[l];
            while(l < r){
                while(l < r && arr[r] >= temp) r--;
                if(l < r) arr[l] = arr[r];
                while(l < r && arr[l] < temp) l++;
                if(l < r) arr[r] = arr[l];
            }
            arr[l] = temp;
            qSort(arr,s,l);
            qSort(arr,l + 1, e);
        }
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
        int[] arr = new int[]{5,2,3,1};

        qSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
