package com.lvxiao.leetcode.medium;

import java.util.*;

/**
 * @author lvxiao
 * @date 2019/4/27
 */
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

public class Solution {


    /*
    https://leetcode.com/problems/copy-list-with-random-pointer/
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node();
            newNode.val = cur.val;
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node copy = head.next;
        cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = tmp.next;
            cur = cur.next;
            if (tmp.next != null) {
                tmp.next = tmp.next.next;
            }
        }
        return copy;
    }

    public String add(String a, String b) {
        String tmp;
        if (a.length() < b.length()) {
            tmp = a;
            a = b;
            b = tmp;
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int pave = 0;
        for (; i > -1; i--) {
            if (i == a.length() - b.length()) {
                break;
            }
            int ai = a.charAt(i) - 48;
            int bi = b.charAt(j--) - 48;
            int all = ai + bi + pave;
            pave = all / 10;
            sb.append(all % 10);
        }
        sb.reverse();
        sb.insert(0, a.subSequence(0, i));
        return sb.toString();
    }

    /**
     * https://leetcode.com/problems/word-break/
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j < s.length() + 1; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
        {
            fast = fast.next;
        }

        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
        {
            slow = slow.next;
        }

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        new Solution().rotateRight(node, 10);
    }
}
