package com.lvxiao.aimoffer;

import com.lvxiao.DataStructHelper.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvxiao
 * @date 2020/6/3
 */
public class Problem35 {
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return head;
        }
        //将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2'->3->3'
        for (Node node = head, copy = null; node != null; node = node.next.next) {
            copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
        }
        //把拷贝节点的random指针安排上
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }
        //分离拷贝节点和原节点，变成1->2->3和1'->2'->3'两个链表，后者就是答案
        Node newHead = head.next;
        for (Node node = head, temp = null; node.next != null;) {
            temp = node.next;
            node.next = temp.next;
            node = temp;
        }

        return newHead;
    }


    public Node copyRandomList(Node head) {
        //成本Node
        Map<Node, Node> nodeMap = new HashMap<>();
        Node p = head;
        while (p != null) {
            nodeMap.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null) {
            nodeMap.get(p).next = nodeMap.get(p.next);
            nodeMap.get(p).random = nodeMap.get(p.random);
            p = p.next;
        }
        return nodeMap.get(head);
    }


    public static void main(String[] args) {
        Problem35 problem = new Problem35();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;

        node2.next = node3;
        node2.random = node1;

        node3.next = node4;
        node3.random = node5;

        node4.next = node5;
        node4.random = node3;

        node5.random = node1;

        Node node = problem.copyRandomList1(node1);
        System.out.println(node);
    }
}
