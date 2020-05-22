package com.lvxiao.aimoffer;

/**
 * @author lvxiao
 * @date 2020/5/19
 */
public class Problem33 {
    /*
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
    如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     */
    public boolean verifyPostorder(int[] postorder) {
        //二叉搜索树，左子节点小于父节点，父节点小于右节点
        //数组的最后一个节点为主节点
        if (postorder.length < 2) {
            return true;
        }
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int divi = end;
        //左子树小于root,右子树大于root
        for (int i = end-1; i >=start; i--) {
            if (postorder[i] < root) {
                divi = i;
                break;
            }
        }
        boolean left = true;
        boolean right = true;
        if (divi >= start) {
            left = verify(postorder, start, divi);
        }
        if (!left) {
            return false;
        }
        if (divi <= end) {
            right = verify(postorder, divi + 1, end-1);
        }
        return right;
    }
}
