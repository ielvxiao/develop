package com.lvxiao.problem11;

/**
 * 11. Container With Most Water
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-21 18:20
 */
public class Problem11 {
    public int maxArea(int[] height) {
        int max = 0;
        //记录之前的最高高度，因为随着宽度的减少，高度如果再减小的话体积肯定不会增大
        int preLeftHight = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < preLeftHight) {
                continue;
            }
            preLeftHight = Math.max(preLeftHight, height[i]);
            int preRightHight = 0;
            for (int j = height.length-1; j >i ; j--) {
                if (height[j] < preRightHight) {
                    continue;
                }
                preRightHight = Math.max(preRightHight, height[j]);
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem11().maxArea(new int[]{2,3,4,5,18,17,6}));
    }
}
