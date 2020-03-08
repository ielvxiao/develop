package com.lvxiao.problem164;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/3/8 4:06 下午
 */
class LRUCache {

    Map<Integer,Integer> map;
    int size;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        size=capacity;
    }

    public int get(int key) {
        if(size==0) return -1;
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }else {
            map.remove(key);
            map.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        if(size==0) return;
        Integer tmp = map.remove(key);
        if(tmp==null&&map.size()==size){
            Iterator<Integer> integerIterator = map.keySet().iterator();
            Integer keyFirst = integerIterator.next();
            map.remove(keyFirst);
        }
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
