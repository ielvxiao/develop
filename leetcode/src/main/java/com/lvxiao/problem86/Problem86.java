package com.lvxiao.problem86;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/6 7:12 下午
 */
public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode tmp = new ListNode(0),cur=tmp,pre=tmp;
        tmp.next = head;
        while (pre.next != null) {
            if (pre.next.val < x) {
                if (cur == pre) {
                    cur = cur.next;
                    pre = pre.next;
                } else {
                    ListNode a = cur.next;
                    ListNode b = pre.next.next;
                    pre.next.next = a;
                    cur.next = pre.next;
                    pre.next = b;
                    cur = cur.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return tmp.next;
    }

    public static void main(String[] args) {
        new Problem86().partition(DataUtils.listNodeCreate(new int[]{3,1,2}), 3);
    }
}
