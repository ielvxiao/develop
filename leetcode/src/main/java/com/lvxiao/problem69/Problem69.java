package com.lvxiao.problem69;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/29 10:52 下午
 */
public class Problem69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int head = 0;
        int tail = x;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            //int sum = mid * mid;
            //此处不用mid*mid防止溢出
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        return Math.min(head, tail);
    }

    public static void main(String[] args) {
        System.out.println(new Problem69().mySqrt(8));
    }
}
