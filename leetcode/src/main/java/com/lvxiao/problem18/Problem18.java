package com.lvxiao.problem18;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-28 16:29
 */
public class Problem18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (target <= 0 && nums[i] > 0) {
                break;
            }
            if (target > 0 && nums[i] > target) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (target <= 0 && nums[i] + nums[j] > 0) {
                    break;
                }
                if (target > 0 && nums[i] + nums[j] > target) {
                    break;
                }
                if (j > i+1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int num = nums[i] + nums[j] + nums[left] + nums[right];
                    if (num == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (num < target) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else {
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Problem18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }
}
