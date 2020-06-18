package com.lvxiao.problem1028;

import com.lvxiao.DataStructHelper.TreeNode;

import java.util.Stack;

/**
 * @author lvxiao
 * @date 2020/6/18
 */
public class Problem1028 {
    public static void main(String[] args) {
        TreeNode node = new Problem1028().recoverFromPreorder("1-2--3--4-5--6--7");
        System.out.println(node);

    }
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //底层坐标
        int index =0;
        while(index<S.length()){
            //层级
            int level = 0;
            while(S.charAt(index)=='-'){
                level++;
                index++;
            }
            int num = 0;
            while(index < S.length()&&S.charAt(index)!='-'){
                num = 10 *num + Character.getNumericValue(S.charAt(index));
                index++;
            }
            TreeNode node = new TreeNode(num);
            if(level==stack.size()){
                if(!stack.isEmpty()){
                    stack.peek().left=node;
                }
            }else{
                while(level!=stack.size())  stack.pop();
                stack.peek().right=node;
            }
            stack.push(node);
        }
        while(stack.size()!=1){
            stack.pop();
        }
        return stack.peek();
    }
}
