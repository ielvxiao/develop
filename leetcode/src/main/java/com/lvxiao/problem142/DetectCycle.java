package com.lvxiao.problem142;

import com.lvxiao.ListNode;

/**
 * 142. Linked List Cycle II
 * @author lvxiao
 * @date 2019/6/4
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode res = head;
        ListNode tmp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                tmp = slow;
                if (tmp != null) {
                    while (res != slow) {
                        slow = slow.next;
                        if (tmp == slow) {
                            res = res.next;
                        }
                    }
                }
                return res;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = node.next;

        new DetectCycle().detectCycle(node);
    }
}
