package com.lvxiao.problem155;



/**
 * 155. Min Stack
 * 解法1：用一个数据结构存储当前节点放入后的最小值，这样即使当前节点是最小值，pop出了当前节点。也能获取到之后节点所有的最小值。
 * 想法非常nice。
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-09 11:03
 */
public class MinStack {
    private Node head;

    public void push(int x) {
        if(head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
