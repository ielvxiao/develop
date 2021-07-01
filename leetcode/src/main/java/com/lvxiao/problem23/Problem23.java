package com.lvxiao.problem23;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

import java.util.*;

/**
 * 23. Merge k Sorted Lists
 *
 * @author lvxiao
 * @date 2019/8/2
 */
public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeNode(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] nodeArr1 = new ListNode[mid];
        System.arraycopy(lists, 0, nodeArr1, 0, mid);
        ListNode[] nodeArr2 = new ListNode[lists.length - mid];
        System.arraycopy(lists, mid, nodeArr2, 0, lists.length - mid);
        return mergeNode(mergeKLists(nodeArr1), mergeKLists(nodeArr2));
    }

    private ListNode mergeNode(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.val <= n2.val) {
            n1.next = mergeNode(n1.next, n2);
            return n1;

        } else {
            n2.next = mergeNode(n2.next, n1);

            return n2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem23().mergeKLists(new ListNode[]{DataUtils.listNodeCreate(new int[]{1, 4, 5}), DataUtils.listNodeCreate(new int[]{1, 3, 4}), DataUtils.listNodeCreate(new int[]{2, 6})}));
    }
}
