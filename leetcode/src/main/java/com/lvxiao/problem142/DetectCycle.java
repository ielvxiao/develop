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
        boolean isCycle = false;
        //看一下是否有环
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        /**
         假设a是环前边的长度，b为环的长度,x为fast与slow相遇的地方离相交处的距离。
         fast 走了 a + nb + x步
         slow 走了 a + mb + x步
         fast = 2low = 2a + 2mb + 2x
         a = (n-2m)b-x
         加入再走a步，则
         fast+a=3a + 2 mb + 2x = a + 2(n-m)b则刚好走到圈的起始处
         */
        if (isCycle) {
            //有环的话从头开始一步一步来
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        } else {
            return null;
        }
    }
}
