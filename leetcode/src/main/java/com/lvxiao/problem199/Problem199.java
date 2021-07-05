package com.lvxiao.problem199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lvxiao.DataStructHelper.TreeNode;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-06-30
 */
public class Problem199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        int size = 1;
        boolean first = true;
        while (!nodeList.isEmpty()) {
            TreeNode poll = nodeList.poll();
            if (first) {
                res.add(poll.val);
                first = false;
            }
            if (poll.right != null) {
                nodeList.add(poll.right);
            }
            if (poll.left != null) {
                nodeList.add(poll.left);
            }
            size--;
            if (size == 0) {
                first = true;
                size = nodeList.size();
            }
        }
        return res;
    }
}
