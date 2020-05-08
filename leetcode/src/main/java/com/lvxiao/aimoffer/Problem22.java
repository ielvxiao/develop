package com.lvxiao.aimoffer;

import com.lvxiao.DataStructHelper.ListNode;

/**
 * @author lvxiao
 * @date 2020/5/8
 */
public class Problem22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null) return null;
        ListNode fast = head;
        while (k>0&& fast!=null) {
            fast = fast.next;
            k--;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
