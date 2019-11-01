package com.lvxiao.problem215;


import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/31 5:26 下午
 */
public class Problem215 {
    /**
     * 解答1：需要改进
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
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
        System.out.println(new Problem215().findKthLargest(new int[]{3, 2, 3, 4, 2, 4, 5, 5,1, 6}, 5));
    }
}
