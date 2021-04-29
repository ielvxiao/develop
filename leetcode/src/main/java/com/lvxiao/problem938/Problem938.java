package com.lvxiao.problem938;

import com.lvxiao.DataStructHelper.TreeNode;

/**
 * @author lvxiao
 * @date 2021/4/29
 */
public class Problem938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (high < root.val) {
            return rangeSumBST(root.left, low, high);
        } else if (low > root.val) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }
}
