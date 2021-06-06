package com.lvxiao.problem102;

import com.lvxiao.DataStructHelper.TreeNode;

import java.util.*;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-06-06
 */
public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode remove = list.removeFirst();
                level.add(remove.val);
                if (remove.left != null) {
                    list.add(remove.left);
                }
                if (remove.right != null) {
                    list.add(remove.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
