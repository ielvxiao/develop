package com.lvxiao.problem146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-05-29
 */
public class LRUCacheFromScratch {
    static CacheNode head = new CacheNode();
    static CacheNode tail = new CacheNode();

    Map<Integer, CacheNode> map;
    int size;

    static class CacheNode {
        int key;
        int val;
        CacheNode pre;
        CacheNode next;
    }


    public LRUCacheFromScratch(int capacity) {
        map = new HashMap<>(capacity);
        size = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        CacheNode node = map.get(key);
        //把node移到最前边
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        CacheNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            node.val = value;
            return;
        }
        node = new CacheNode();
        node.val = value;
        node.key = key;
        addToHead(node);
        map.put(key, node);
        if (map.size() > size) {
            int removeKey = removeTail();
            map.remove(removeKey);
        }
    }
    private int  removeTail() {
        CacheNode node = tail.pre;
        tail.pre = node.pre;
        node.pre.next = node.next;
        return node.key;
    }
    private void moveToHead(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addToHead(node);
    }

    private void addToHead(CacheNode node) {
        CacheNode first = head.next;
        head.next = node;
        node.next = first;
        first.pre = node;
        node.pre = head;
    }

    public static void main(String[] args) {
        LRUCacheFromScratch lRUCache = new LRUCacheFromScratch(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
