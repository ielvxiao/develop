package com.lvxiao.problem538;

import com.lvxiao.DataStructHelper.TreeNode;

/**
 * @author lvxiao
 * @date 2020/9/21
 */
public class Problem538 {
    int num;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            //先执行roo.right逻辑，这样root的val就不会被加进去。。。。
            convertBST(root.right);
            //然后执行root逻辑，这样可以加上right的逻辑
            root.val += num;
            num = root.val;
            //最后执行left的逻辑，这样可以加上right和root。。
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        //[2,0,3,-4,1]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);
        TreeNode treeNode = new Problem538().convertBST(root);
        System.out.println(treeNode);
    }
}
