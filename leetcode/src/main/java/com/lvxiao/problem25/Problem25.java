package com.lvxiao.problem25;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/27 5:21 下午
 */
public class Problem25 {
    //不用递归解法
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode tmp = dummy;
        out:
        while (head != null) {
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    break out;
                }
                head = head.next;
            }
            ListNode old = tmp.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode next = old.next;
                ListNode nextnext = next.next;
                next.next = tmp.next;
                old.next = nextnext;
                tmp.next = next;
            }
            for (int i = 0; i < k; i++) {
                tmp = tmp.next;
            }
        }
        return dummy.next;
    }
    /**
     * 翻转链表[a,b)
     * @param a
     * @param b
     * @return
     */
    private ListNode reverseNode(ListNode a, ListNode b) {
        ListNode tmp = a;
        while (tmp.next != b) {
            ListNode tmp1 = tmp.next.next;
            tmp.next.next = a;
            a = tmp.next;
            tmp.next = tmp1;
        }
        return a;
    }

    /**
     * 将问题分解为若干个翻转链表问题.
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int group = k;
        ListNode a = head, b = head;
        for (int i = 0; i < group; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverseNode(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new Problem25().reverseKGroup(DataUtils.listNodeCreate(new int[]{1, 2, 3, 4, 5}),2);
        System.out.println(listNode);
    }
}
