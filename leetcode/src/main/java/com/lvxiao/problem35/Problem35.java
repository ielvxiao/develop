package com.lvxiao.problem35;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/28 8:52 下午
 */
public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int head = 0;
        int tail = nums.length - 1;
        int result = -1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] == target) {
                result = mid;
                //继续找最小的result
                tail = mid - 1;
            } else if (nums[mid] < target) {
                head = mid + 1;
                //防止不存在target的情况
                if (head <= tail && nums[head] > target) {
                    return head;
                }
            } else {
                tail = mid - 1;
                //防止不存在target的情况
                if (head <= tail && nums[tail] < target) {
                    return mid;
                }
            }
        }
        if (result != -1) {
            return result;
        }
        if (head > nums.length - 1) {
            return nums.length;
        }
        if (tail < 0) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem35 problem35 = new Problem35();
        System.out.println(problem35.searchInsert(new int[]{1}, 0));
    }
}
