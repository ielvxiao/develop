package com.lvxiao.problem129;

import com.lvxiao.DataStructHelper.TreeNode;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-15
 */
public class Problem129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int val) {
        val += root.val;
        if (root.left == null && root.right == null) {
            sum += val;
        }
        if (root.left != null) {
            helper(root.left, val * 10);
        }
        if (root.right != null) {
            helper(root.right, val * 10);
        }
    }
}
