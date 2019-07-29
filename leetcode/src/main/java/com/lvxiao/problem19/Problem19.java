package com.lvxiao.problem19;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-29 21:25
 */
public class Problem19 {
    /**
     * 使用快慢指针遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        int i;
        for (i = 1; i <= n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        if (i == n + 1 && fast == null) {
            return head.next;
        }
        if (fast == null) {
            return null;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Problem19().removeNthFromEnd(DataUtils.binarySearchTree(new int[]{1,2,3,4,5}), 2).val);
    }
}
