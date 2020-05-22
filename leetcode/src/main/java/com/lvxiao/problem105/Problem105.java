package com.lvxiao.problem105;

import com.lvxiao.DataStructHelper.TreeNode;

import java.util.Stack;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Related Topics 树 深度优先搜索 数组
 *
 * @author lvxiao
 * @date 2020/5/22
 */
public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }


    // 跟踪根节点的值
    int i = 0;
    public TreeNode buildTreeRec(int[] preorder, int[] inorder) {
        return create(preorder, inorder, 0, preorder.length - 1);
    }

    public TreeNode create(int[] preorder, int[] inorder, int left, int right) {
        // 限定范围
        if (left > right)
            return null;
        // 从左范围出发，从中序遍历中找到与根节点相同的值
        int j = left;
        while (j <= right && preorder[i] != inorder[j])
            j++;
        // 构造树，并将i指向下一位
        TreeNode root = new TreeNode(preorder[i++]);
        // 根据中序遍历左区间，构造左子树
        root.left = create(preorder, inorder, left, j - 1);
        // 根据中序遍历有区间，构造右子树
        root.right = create(preorder, inorder, j + 1, right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Problem105().buildTreeRec(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.out.println(treeNode);
    }
}
