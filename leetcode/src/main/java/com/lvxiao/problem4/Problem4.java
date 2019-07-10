package com.lvxiao.problem4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-09 21:50
 */
public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int mid = (nums1.length + nums2.length - 1) / 2;
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (nums1[(length1 - 1) / 2] < nums2[(length2 - 1) / 2]) {

        }
        return 0;
    }

}
