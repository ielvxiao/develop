package com.lvxiao.DataStructHelper;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-02 22:37
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
