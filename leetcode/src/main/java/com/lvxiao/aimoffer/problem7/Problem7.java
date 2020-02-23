package com.lvxiao.aimoffer.problem7;

import com.lvxiao.DataStructHelper.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/22 11:13 下午
 */
public class Problem7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return helper(preorder, in, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] pre, List<Integer> in, int prestart, int preend, int instart, int inend) {
        if (prestart > preend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(pre[prestart]);
        int index = in.indexOf(pre[prestart]);
        root.left = helper(pre, in, prestart + 1, prestart + index - instart, instart, index - 1);
        root.right = helper(pre, in, prestart + index - instart + 1, preend, index + 1, inend);
        return root;
    }

    public static void main(String[] args) {
        new Problem7().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
