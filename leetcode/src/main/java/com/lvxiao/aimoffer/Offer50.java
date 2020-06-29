package com.lvxiao.aimoffer;

/**
 * @author lvxiao
 * @date 2020/6/29
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        if(s.length()==0)   return ' ';
        int[] target = new int[26];
        for(int i=0;i<s.length();i++){
            target[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(target[s.charAt(i)-'a']==1)    return s.charAt(i);
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println('c'+1);
    }
}
