package com.lvxiao.problem160;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/27 4:25 下午
 */
public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    public static void main(String[] args) {
        ListNode node1 = DataUtils.listNodeCreate(new int[]{4,1,8,4,5});
        ListNode node2 = DataUtils.listNodeCreate(new int[]{5,0,1,8,4,5});
        ListNode res = new Problem160().getIntersectionNode(node1, node2);
        System.out.println(res.val);
    }
}
