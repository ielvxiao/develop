package com.lvxiao.problem1207;

import java.util.*;
/**
 * @author lvxiao
 * @date 2020/10/28
 */
public class Problem1207 {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr.length<2)    return true;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        for (int i = 0; i < list.size(); i++) {
            if (list.lastIndexOf(list.get(i)) != i) {
                return false;
            }
        }
        return true;
    }
}
