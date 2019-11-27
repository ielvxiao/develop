package com.lvxiao.problem4;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-09 21:50
 */
public class Problem4 {

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * 寻找第k个数
     *
     * @param nums1  数组1
     * @param index1 数组1查询开始坐标
     * @param nums2  数组2
     * @param index2 数组2查询开始坐标
     * @param k      坐标
     * @return int
     */
    public int findKth(int[] nums1, int index1, int[] nums2, int index2, int k) {
        if (index1 >= nums1.length) return nums2[index2 + k - 1];//nums1为空数组
        if (index2 >= nums2.length) return nums1[index1 + k - 1];//nums2为空数组
        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }
        int midVal1 = (index1 + k / 2 - 1 < nums1.length) ? nums1[index1 + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (index2 + k / 2 - 1 < nums2.length) ? nums2[index2 + k / 2 - 1] : Integer.MAX_VALUE;
        //midVal1<midVal2，可能是midVal1<midVal2或者midVal2长度太短，则，此时，需要将保持将index1坐标右移动k/2，此时从1,2坐标寻找第k - k / 2小就行
        if (midVal1 < midVal2) {
            return findKth(nums1, index1 + k / 2, nums2, index2, k - k / 2);
        } else {
            return findKth(nums1, index1, nums2, index2 + k / 2, k - k / 2);
        }
    }
}

