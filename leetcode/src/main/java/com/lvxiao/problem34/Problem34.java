package com.lvxiao.problem34;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/16 8:19 下午
 */
public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int head = 0;
        int tail = nums.length - 1;
        boolean no = true;
        //2分查找是否有相同值
        int mid = -1;
        while (head <= tail) {
            mid = (head + tail) / 2;
            if (nums[mid] == target) {
                Arrays.fill(res, mid);
                no = false;
                break;
            }
            if (nums[mid] < target) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        if (no) {
            return res;
        }
        searchRangeHelper(nums, res, target, true, mid-1);
        searchRangeHelper(nums, res, target, false, mid+1);
        return res;
    }

    /**
     * 定位前后界限
     *
     * @param nums
     * @param res
     * @param target
     * @param left
     */
    private void searchRangeHelper(int[] nums, int[] res, int target, boolean left, int lim) {
        int head = left ? 0 : lim;
        int tail = left ? lim : nums.length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] == target) {
                res[left ? 0 : 1] = mid;
                if (left && mid > 0) {
                    searchRangeHelper(nums, res, target, left, mid-1);
                }
                if (!left && mid < nums.length - 1) {
                    searchRangeHelper(nums, res, target, left, mid+1);
                }
                break;
            }
            if (nums[mid] < target) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem34().searchRange(new int[]{2,2}, 2)));
    }
}
