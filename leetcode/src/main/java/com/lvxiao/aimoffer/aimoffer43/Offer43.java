package com.lvxiao.aimoffer.aimoffer43;

/**
 * @author lvxiao
 * @date 2020/6/18
 */
public class Offer43 {
    public static void main(String[] args) {
        System.out.println(new Offer43().countDigitOne(12));
    }
    public int countDigitOne(int n) {
        int high = n/10,cur=n%10,dig=1,low=0,res=0;
        while(high>0||cur>0){
            res+=high*dig;
            if (cur==1){
                res+=low+1;
            }else if(cur>1){
                res+=dig;
            }
            dig*=10;
            low=n%dig;
            cur=high%10;
            high/=10;
        }
        return res;
    }
}
