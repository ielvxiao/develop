package com.lvxiao.problem25;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/27 5:21 下午
 */
public class Problem25 {
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
