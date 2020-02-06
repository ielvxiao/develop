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
        if (head == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            //这种情况是开头时候出现的
            if (slow.val == fast.val) {
                fast = fast.next;
                while (fast != null && slow.val == fast.val) {
                    fast = fast.next;
                }
                slow = fast;
                if (fast == null) {
                    return slow;
                }
                head = slow;
                fast = fast.next;
            } else {
                //已结束判断
                if (fast.next == null) {
                    return head;
                } else if (fast.next.val != fast.val) { //后边也是不相等
                    slow = fast;
                    fast = fast.next;
                } else {    //出现相等的节点
                    while (fast.next != null && fast.next.val == fast.val) {
                        fast = fast.next;
                    }
                    slow.next = fast.next;
                    fast = fast.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new Problem82().deleteDuplicates(DataUtils.listNodeCreate(new int[]{1,1}));
    }

}
