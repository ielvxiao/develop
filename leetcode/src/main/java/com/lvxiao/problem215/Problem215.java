package com.lvxiao.problem215;


import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/31 5:26 下午
 */
public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        return help(nums, k, 0, nums.length - 1);
    }

    private int help(int[] nums, int k, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int pave = nums[left];
        int i = left,j=right;
        while (i < j) {
            while (i<j&&nums[j]<pave) j--;
            if (i < j) {
                nums[i] = nums[j];
            }
            while (i<j&&nums[i]>=pave) i++;
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        if (i+1 == k) {
            return pave;
        }
        nums[i] = pave;
        if (i+1 < k) {
            return help(nums, k, i+1, right);
        } else {
            return help(nums, k, left, i-1);
        }
    }

        public int findKthLargestHeap(int[] nums, int k) {
            for (int i = 0; i < k; i++) {
                heapInsert(nums, i);
            }
            return nums[k - 1];
        }


        //构造大根堆（通过新插入的数上升）
        public static void heapInsert(int[] arr, int index) {

            for (int i = index; i < arr.length; i++) {
                int start = i;
                int father = (start + index - 1) / 2;
                while (arr[start] > arr[father]) {
                    swap(arr, father, start);
                    start = father;
                    father = (start + index - 1) / 2;
                }
            }
        }


        //交换数组中两个元素的值
        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    public static void main(String[] args) {
        System.out.println((int)' ');
    }
}
