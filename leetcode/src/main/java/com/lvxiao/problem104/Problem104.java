package com.lvxiao.problem104;

import com.lvxiao.DataStructHelper.TreeNode;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-05
 */
public class Problem104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
