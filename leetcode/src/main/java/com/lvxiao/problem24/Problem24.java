package com.lvxiao.problem24;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-08-08 22:21
 */
public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(-1), tmp = res;
        while (head != null) {
            tmp.next = swapPairsHelper(head);
            if (head.next == null) {
                return res.next;
            }
            tmp = head;
            head = head.next;
        }
        return res.next;
    }

    private ListNode swapPairsHelper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l1 = head, l2 = head.next, tmp = l2.next;
        l2.next = l1;
        l1.next = tmp;
        return l2;
    }

    public static void main(String[] args) {
    }
}
