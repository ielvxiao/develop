package com.lvxiao.problem142;

import com.lvxiao.DataStructHelper.ListNode;

/**
 * 142. Linked List Cycle II
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-03 22:55
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode sslow = null;
        ListNode tmp = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                tmp = slow;
            }
        }
        if (tmp != null) {

        }
        return null;
    }
}
