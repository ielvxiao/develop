package com.lvxiao.problem83;

import com.lvxiao.DataStructHelper.ListNode;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/6 4:41 下午
 */
public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
