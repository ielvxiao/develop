package com.lvxiao.problem52;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvxiao
 * @date 2020/10/17
 */
public class Problem52 {
    public static void main(String[] args) {
        System.out.println(new Problem52().totalNQueens(4));
    }
    int res = 0;
    List<Integer> list;
    public int totalNQueens(int n) {
        list = new ArrayList(n);
        helper(n);
        return res;
    }

    private void helper(int n){
        if(list.size()==n){
            res++;
            return;
        }
        for(int i=0;i<n;i++){
            if(!contains(list,i)){
                list.add(i);
                helper(n);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean contains(List<Integer> list, int j){
        int size = list.size();
        for(int i = 0; i< size; i++){
            int num = list.get(i);
            if(j==num||(i+list.get(i))== (size+j)||(list.get(i)-i)==(j-size)){
                return true;
            }
        }
        return false;
    }
}
