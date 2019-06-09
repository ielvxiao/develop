package com.lvxiao.problem155;

import java.util.Stack;

/**
 * 解法2：每次push的时候，如果当前值是最小值则将次小值放入该最小值后边，这样就能解决pop后无法知晓最小值的问题。
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-09 11:25
 */
public class MinStack1 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) {
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
