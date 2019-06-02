package com.lvxiao.problem98;

import com.lvxiao.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-02 14:56
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root,null,null);
    }

    private boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        } else if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(20);
        System.out.println(new IsValidBST().isValidBST(node));
    }
}
