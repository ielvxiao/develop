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

    int [] nums;

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }


    public int partition(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public int quickselect(int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list within left..right.
    */

        if (left == right) // If the list contains only one element,
        {
            return this.nums[left];  // return that element
        }

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        pivot_index = partition(left, right, pivot_index);

        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index) {
            return this.nums[k_smallest];
        }
            // go left side
        else if (k_smallest < pivot_index) {
            return quickselect(left, pivot_index - 1, k_smallest);
        }
        // go right side
        return quickselect(pivot_index + 1, right, k_smallest);
    }

    public int findKthLargestQuickSelect(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        // kth largest is (N - k)th smallest
        return quickselect(0, size - 1, size - k);
    }

    public static void main(String[] args) {
        System.out.println(new Problem215().findKthLargest(new int[]{3, 2, 3, 4, 2, 4, 5, 5,1, 6}, 5));
    }
}
