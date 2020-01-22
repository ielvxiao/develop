package com.lvxiao.problem61;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/18 8:05 下午
 */
public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        int tmp_k = k;
        while (tmp_k > 0) {
            if (fast == null) {
                break;
            }
            fast = fast.next;
            tmp_k--;
            len++;
        }
        if (len == 0 || (len == 1 && fast == null)) {
            return head;
        }
        ListNode tail = null;
        if (fast == null) {
            return rotateRight(head, k % len);
        } else {
            while (fast != null) {
                if (fast.next == null) {
                    tail = fast;
                    break;
                }
                fast = fast.next;
                slow = slow.next;
            }
        }
        ListNode tmp = slow.next;
        slow.next = null;
        tail.next = head;
        return tmp;
    }

    public static void main(String[] args) {
        ListNode node = DataUtils.listNodeCreate(new int[]{0, 1, 2});
        ListNode result = new Problem61().rotateRight(node, 4);
    }
}
