package com.lvxiao.problem113;

import com.lvxiao.DataStructHelper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-11
 */
public class Problem113 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        backTrace(new ArrayList<>(), root, targetSum);
        return res;
    }

    private void backTrace(List<Integer> list, TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }
        }
        if (root.left != null) {
            list.add(root.val);
            backTrace(list, root.left, targetSum - root.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.val);
            backTrace(list, root.right, targetSum - root.val);
            list.remove(list.size() - 1);

        }
    }

}
