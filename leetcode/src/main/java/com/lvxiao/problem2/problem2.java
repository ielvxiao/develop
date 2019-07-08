package com.lvxiao.problem2;

import com.lvxiao.DataStructHelper.ListNode;

/**
 * 2. Add Two Numbers
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-08 23:35
 */
public class problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int forward = 0;
        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        while (l1 != null || l2 != null) {
            int nl1 = 0;
            int nl2 = 0;
            if (l1 != null) {
                nl1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                nl2 = l2.val;
                l2 = l2.next;
            }
            int sum = nl1 +nl2 + forward;
            forward = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
        }
        if (forward != 0) {
            tmp.next = new ListNode(forward);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next= new ListNode(4);
        l1.next.next= new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        new problem2().addTwoNumbers(l1, l2);
    }
}
