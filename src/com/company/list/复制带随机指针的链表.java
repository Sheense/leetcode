package com.company.list;

import com.company.common.other.Node;

public class 复制带随机指针的链表 {

    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
        if(head== null) return null;
         Node root = head;
         Node now = new Node(root.val);
         Node newHead = now;
         while(root.next!=null) {
             now.next = new Node(root.next.val);
             now = now.next;
             root = root.next;
         }
         root = head;
         Node newRoot = newHead;
         while(root!=null) {
             if(root.random!=null) {
                 Node target = root.random;
                 Node item = head;
                 Node item1 = newHead;
                 while(item!=target) {
                     item = item.next;
                     item1 = item1.next;
                 }
                 newRoot.random = item1;
             }
             root = root.next;
             newRoot = newRoot.next;
         }
        return newHead;
    }
}
