package com.lvxiao.aimoffer.problem7;

/**
 * @author lvxiao
 * @date 2020/6/19
 */
public class Offer44 {
    public static void main(String[] args) {
        System.out.println(new Offer44().findNthDigit(1000000000));
    }
    public int findNthDigit(int n) {
        if(n<10)    return n;
        long base = 10;
        n-=10;
        int len=2;
        while(n>len*9*base){
            n-=(len++)*9*base;
            base*=10;
        }
        long a = n/len+base;
        long b = n % len;

        long res = a / (int) Math.pow(10, len - 1 - b);
        return (int)res%10;
    }
}
