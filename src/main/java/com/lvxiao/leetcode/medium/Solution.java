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
}

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

    /*
    https://leetcode.com/problems/unique-paths-ii/
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /*
    https://leetcode.com/problems/unique-paths-ii/
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = -1;
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = -1;
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = -1;
                    continue;
                }
                if (dp[i - 1][j] == -1) {
                    dp[i][j] = dp[i][j - 1];
                } else if (dp[i][j - 1] == -1) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == -1 ? 0 : dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    /**
     * https://leetcode.com/problems/sort-list/discuss/46714/Java-merge-sort-solution
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }

    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return merge(l1, l2);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    Given a binary tree, return the inorder traversal of its nodes' values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inorderHelper(node.left, result);
        }
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    /*
    96. Unique Binary Search Trees
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generateTreesHelper(start, i - 1);
            List<TreeNode> rightSubtrees = generateTreesHelper(i + 1, end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    /**
     * 95. Unique Binary Search Trees II
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] memo = new int[n+1];
        memo[0] = 1;
        return numTrees(n, memo);
    }

    private int numTrees(int n, int[] memo) {
        if(memo[n] != 0) return memo[n];
        for(int i=1; i<=n; i++) {
            memo[n] += numTrees(i-1, memo) * numTrees(n-i, memo);
        }
        return memo[n];
    }


    /**
     * 1916797311
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        System.out.println(new Solution().numTrees(3));
    }
}
