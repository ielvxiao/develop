package com.lvxiao;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-08-01
 */
public class Problem347 {
    public static void main(String[] args) {
        final int[] ints = new Problem347().topKFrequent(new int[]{3,0,1,0}, 1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private class Node {
        int val;
        int count;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        Map<Integer, Node> map = new HashMap<>();
        for (int num : nums) {
            Node node = map.get(num);
            if (node == null) {
                node = new Node(num, 1);
                map.put(num, node);
                queue.add(node);
            } else {
                node.count = node.count + 1;
                queue.remove(node);
                queue.add(node);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().val;
        }
        return res;
    }
}
