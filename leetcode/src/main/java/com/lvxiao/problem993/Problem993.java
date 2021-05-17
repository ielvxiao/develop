package com.lvxiao.problem993;

import com.lvxiao.DataStructHelper.TreeNode;


/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-05-17
 */
public class Problem993 {
    int depX, depY, pX, pY;
    boolean fx, fy;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, -1);
        return depY == depX && pY != pX;
    }

    private void dfs(TreeNode root, int x, int y, int dep, int parent) {
        int val = root.val;
        if (val == x) {
            depX = dep;
            pX = parent;
            fx = true;
        } else if (val == y) {
            depY = dep;
            pY = parent;
            fy = true;
        }
        if (fx && fy) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, x, y, dep + 1, val);
        }
        if (fx && fy) {
            return;
        }
        if (root.right != null) {
            dfs(root.right, x, y, dep + 1, val);
        }
    }
}
