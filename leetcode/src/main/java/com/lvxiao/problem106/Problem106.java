package com.lvxiao.problem106;

import com.lvxiao.DataStructHelper.TreeNode;

import java.util.Stack;

/**
 * @author lvxiao
 * @date 2020/5/22
 */
//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
public class Problem106 {
    public static void main(String[] args) {
        TreeNode treeNode = new Problem106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }

    int i = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = inorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int j = left;
        while (j <= right && postorder[i] != inorder[j])
            j++;
        TreeNode root = new TreeNode(postorder[i--]);
        root.right = build(inorder, postorder, j + 1, right);
        root.left = build(inorder, postorder, left, j - 1);
        return root;
    }
}
