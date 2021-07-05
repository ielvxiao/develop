package com.lvxiao.problem144;

import java.util.ArrayList;
import java.util.List;
import com.lvxiao.DataStructHelper.TreeNode;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-05
 */
public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    private void preorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(res, root.left);
        preorder(res, root.right);
    }
}
