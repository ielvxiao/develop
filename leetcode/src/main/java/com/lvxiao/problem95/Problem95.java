package com.lvxiao.problem95;

import com.lvxiao.DataStructHelper.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/15 3:45 下午
 */
public class Problem95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n == 0) {
            return res;
        }
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (end < start) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTreesHelper(start, i - 1); //左侧自树
            List<TreeNode> right = generateTreesHelper(i + 1, end);  //右侧子树
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> list = new Problem95().generateTrees(3);
        System.out.println(list.size());
    }
}
