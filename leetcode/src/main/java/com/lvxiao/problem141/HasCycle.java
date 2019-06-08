package com.lvxiao.problem141;

import com.lvxiao.ListNode;

/**
 * 141. Linked List Cycle
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-02 22:37
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
