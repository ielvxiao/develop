package com.lvxiao.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/31 9:43 上午
 */
public class ArrayAndLinked {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals("two")){
                list.remove(i);
            }
        }
        System.out.println(list); //[one, two, two]
        for(String s:list){
            if(s.equals("two")){
                list.remove(s);
            }
        }
        System.out.println(list); // java.util.ConcurrentModificationException

        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String s = iter.next();
            if(s.equals("two")){
                iter.remove();
            }
        }
        System.out.println(list);   //[one]
    }
}
