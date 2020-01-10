package com.lvxiao.problem50;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/10 3:29 下午
 */
public class Problem50 {
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        new Problem50().myPow(2.0, 2);
    }
}
