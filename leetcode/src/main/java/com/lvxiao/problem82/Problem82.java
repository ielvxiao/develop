package com.lvxiao.problem82;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/5 4:04 下午
 */
public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (head.val == next.val) {
            while (next != null && head.val == next.val) {
                head = next;
                next = next.next;
            }
            head = deleteDuplicates(next);
        } else {
            head.next = deleteDuplicates(next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new Problem82().deleteDuplicates(DataUtils.listNodeCreate(new int[]{1,1}));
    }

}
