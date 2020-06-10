package com.lvxiao;

/**
 * @author lvxiao
 * @date 2020/6/10
 */
public class Qsort {

    public static void main(String[] args) {
        int[] arr =   {1,2,3,4,5};

        quickSort(arr);
    }
    public static void quickSort(int[] nums){
        sort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void sort(int[] nums,int left,int right){
        if (left >= right) {
            return;
        }
        int lo = left;
        int hi = right;
        int pave = nums[left];
        while (lo < hi) {
            while (lo<hi&&nums[hi]>=pave) hi--;
            if (lo < hi) {
                nums[lo] = nums[hi];
            }
            while (lo<hi&&nums[lo]<pave) lo++;
            if (lo < hi) {
                nums[hi] = nums[lo];
            }
        }
        nums[lo] = pave;
        sort(nums,left,lo-1);
        sort(nums,lo+1,right);
    }
}
