package com.lvxiao.problem33;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-08-18 15:56
 */
public class Problem33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[start]) {
                //mid位于前部分递增区间
                if (nums[mid] > target && nums[start] <= target) {
                    //target可能位于[start,mid)
                    end = mid - 1;
                } else {
                    //target可能位于（mid,end）
                    start = mid + 1;
                }
            } else {
                //mid位于后部分递增区间
                if (target <= nums[end] && nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Problem33 problem33 = new Problem33();
        System.out.println(problem33.search(new int[]{3,1}, 1
        ));
    }
}
