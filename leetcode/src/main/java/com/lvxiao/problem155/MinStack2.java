package com.lvxiao.problem155;

import java.util.*;

/**
 * @author lvxiao
 * @date 2020/6/17
 */
public class MinStack2 {
    public static void main(String[] args) {
        MinStack2 stack2 = new MinStack2();
        stack2.push(-2);
        stack2.push(0);
        stack2.push(-1);
        System.out.println(stack2.top());
        System.out.println(stack2.min());
        stack2.pop();
        System.out.println(stack2.min());
    }
    LinkedList<Integer> list= new LinkedList<>();
    PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
    /** initialize your data structure here. */
    public MinStack2() {

    }

    public void push(int x) {
        list.addFirst(x);
        queue.add(x);
    }

    public void pop() {
        queue.remove(list.removeFirst());
    }

    public int top() {
        return list.peek();
    }

    public int min() {
        return queue.peek();
    }
}
