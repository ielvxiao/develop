package com.lvxiao.problem206;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/30 3:21 下午
 */
public class Problem206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode la = null;
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = la;
            la = pre;
            pre = tmp;
        }
        return la;
    }

    public static void main(String[] args) {
        new Problem206().reverseList(DataUtils.listNodeCreate(new int[]{1, 2}));
    }
}
