package com.lvxiao.problem23;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

import java.util.*;

/**
 * 23. Merge k Sorted Lists
 * @author lvxiao
 * @date 2019/8/2
 */
public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.val < o2.val){
                return -1;
            }
            else if (o1.val == o2.val){
                return 0;
            }
            else{
                return 1;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tmp.next = node;
            tmp = node;
            node = node.next;
            if (node != null) {
                queue.add(node);
            }
        }
        return res.next;
    }
}
