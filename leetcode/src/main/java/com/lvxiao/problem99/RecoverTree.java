package com.lvxiao.problem99;

import com.lvxiao.TreeNode;
import lombok.extern.log4j.Log4j2;

/**
 * 99. Recover Binary Search Tree
 *
 * @author lvxiao
 * @date 2019/6/4
 */
@Log4j2
public class RecoverTree {
    public void morrisTraversal(TreeNode root) {
        TreeNode cur = root, prev = null;
        StringBuffer sb = new StringBuffer();
        while (cur != null) {
            if (cur.left == null) {
                log.error(cur.val + " ");
                cur = cur.right;
            } else {
                // find the predecessor
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    log.error(cur.val + " ");
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null, second = null;
        // Morris Traversal
        TreeNode temp = null;
        while (root != null) {
            if (root.left != null) {
                // connect threading for root
                temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                // the threading already exists
                if (temp.right != null) {
                    if (pre != null && pre.val > root.val) {
                        if (first == null) {
                            first = pre;
                        }
                        second = root;
                    }
                    pre = root;

                    temp.right = null;
                } else {
                    // construct the threading
                    temp.right = root;
                }
                root = root.left;
            } else {
                if (pre != null && pre.val > root.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        // swap two node values;
        if (first != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        new RecoverTree().morrisTraversal(root);
    }
}
