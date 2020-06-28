package com.lvxiao.problem209;

/**
 * @author lvxiao
 * @date 2020/6/28
 */
public class Problem209 {
    public static void main(String[] args) {
        System.out.println(new Problem209().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
    public int minSubArrayLen(int s, int[] nums) {
        int start=0;
        int len=0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                len=len==0?i-start+1:Math.min(i-start+1,len);
                sum -= nums[start++];
            }
        }
        return len;
    }
}
