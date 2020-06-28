package com.lvxiao.problem124;

import com.lvxiao.DataStructHelper.TreeNode;

/**
 * @author lvxiao
 * @date 2020/6/22
 */
public class Problem124 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getmax(root);
        return max;
    }

    int getmax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getmax(root.left));
        int right = Math.max(0, getmax(root.right));
        max = Math.max(max, root.val + left + right);
        return root.val + left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Problem124().maxPathSum(root));
    }
}
