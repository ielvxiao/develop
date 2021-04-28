package com.lvxiao.problem633;

/**
 * @author lvxiao
 * @date 2021/4/28
 */
public class Problem633 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            }
            if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new Problem633().judgeSquareSum(5));
    }
}
