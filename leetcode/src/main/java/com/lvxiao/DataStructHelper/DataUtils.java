package com.lvxiao.DataStructHelper;

/**
 * leetCode常用的一些数据结构的转换
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-09 00:10
 */
public class DataUtils {
    /**
     * 构建ListNode结构
     * @param arr   数组
     * @return  返回ListNode结构
     */
    public static ListNode listNodeCreate(int[] arr) {
        ListNode listNode = new ListNode(0);
        ListNode p = listNode;
        for (int i : arr) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return listNode.next;
    }
}
