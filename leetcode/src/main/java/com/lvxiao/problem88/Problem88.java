package com.lvxiao.problem88;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/7 12:24 下午
 */
public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m-- + n-- - 1;
        while (index >= 0) {
            if (n < 0) {
                break;
            }
            if (m < 0 || nums1[m] < nums2[n]) {
                nums1[index--] = nums2[n];
                n--;
            }else{
                nums1[index--] = nums1[m];
                m--;
            }
        }
    }
}
