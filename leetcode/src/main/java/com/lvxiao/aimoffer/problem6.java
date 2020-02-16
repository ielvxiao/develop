package com.lvxiao.aimoffer;

import com.lvxiao.DataStructHelper.DataUtils;
import com.lvxiao.DataStructHelper.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/14 5:41 下午
 */
public class problem6 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++]=stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new problem6().reversePrint(DataUtils.listNodeCreate(new int[]{1, 2, 3}))));
    }
}
