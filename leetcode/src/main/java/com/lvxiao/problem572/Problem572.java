package com.lvxiao.problem572;

import com.lvxiao.DataStructHelper.TreeNode;

/**
 * @author lvxiao
 * @date 2020/5/7
 */
public class Problem572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return true;
        }
        return isSubtreeHelper(s, t);
    }

    private boolean isSubtreeHelper(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null&&t!=null) {
            if (s.val == t.val && isSame(s, t)) {
                return true;
            } else {
                return isSubtreeHelper(s.left, t) || isSubtreeHelper(s.right, t);
            }
        }
        return false;
    }
    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return isSame(left.left, right.left) && isSame(left.right, right.right);
    }
}
