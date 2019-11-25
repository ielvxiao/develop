package com.lvxiao.problem27;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/23 10:42 下午
 */
public class Problem27 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        new Problem27().removeElement(new int[]{3, 2, 2, 3}, 3);
    }
}
