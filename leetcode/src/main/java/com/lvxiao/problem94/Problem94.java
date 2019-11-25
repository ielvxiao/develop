package com.lvxiao.problem94;

import com.lvxiao.DataStructHelper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/25 9:11 下午
 */
public class Problem94 {
    /**
     * Recursive solution
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> res = new  ArrayList<>();
        rec(res, root);
        return res;
    }

    private void rec(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        rec(res, root.left);
        res.add(root.val);
        rec(res,root.right);
    }

    /**
     * stack solution
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalStack(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> res = new  ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
