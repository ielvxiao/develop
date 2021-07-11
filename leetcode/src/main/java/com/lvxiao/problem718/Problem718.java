package com.lvxiao.problem718;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-07
 */
public class Problem718 {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int max = 0;
        //A固定，移动B
        for (int i = 0; i < len1; i++) {
            int len = Math.min(len1-i, len2);
            int tmp = maxLen(nums1, nums2, i, 0, len);
            max = Math.max(max,tmp);
        }
        for (int i = 0; i < len2; i++) {
            int len = Math.min(len1, len2-i);
            int tmp = maxLen(nums1, nums2, 0, i, len);
            max = Math.max(max,tmp);
        }
        return max;
    }

    private int maxLen(int[] nums1, int[] nums2, int start1, int start2, int len) {
        int max = 0;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[start1 + i] == nums2[start2 + i]) {
                k++;
            } else {
                k = 0;
            }
            max = Math.max(max, k);
        }
        return max;
    }
    public int findLengthForce(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] != nums2[j]) {
                    continue;
                }
                int start = i;
                int index2 = j;
                while (index2 < nums2.length) {
                    if (start < nums1.length && nums1[start] == nums2[index2]) {
                        start++;
                        index2++;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, index2 - j);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem718().findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }
}
