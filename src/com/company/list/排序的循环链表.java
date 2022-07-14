package com.company.list;

/**
 * @Classname 排序的循环链表
 * @Date 2022/6/18 12:32 上午
 * @Created by sheen
 * @Description TODO
 */
public class 排序的循环链表 {
    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(3);
        root.next.next = new Node(5);
        root.next.next.next = root;
        排序的循环链表 s = new 排序的循环链表();
        s.insert(root, 4);
    }
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        if(head.next == head) {
            Node node = new Node(insertVal);
            head.next = node;
            node.next = head;
            return head;
        }
        Node next = head;
        while (true) {
            if(next.val == insertVal) {
                break;
            }
            if(next.val < insertVal && next.next.val > insertVal) {
                break;
            }
            if(next.val < insertVal &&  next.next == head) {
                break;
            }
            if(next.val < insertVal && next.next.val < next.val ) {
                break;
            }
            if(next.val > insertVal && next.next == head) {
                break;
            }
            if(next.val > insertVal && next.next.val < next.val && next.next.val > insertVal ) {
                break;
            }
            next = next.next;
        }
        Node node = new Node(insertVal);
        Node n = next.next;
        next.next = node;
        node.next = n;
        return head;
    }
}
