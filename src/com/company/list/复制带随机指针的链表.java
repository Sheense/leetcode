package com.company.list;

import com.company.common.other.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 复制带随机指针的链表 {

    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
        if(head== null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node now = newHead;
        Node root = head;
        map.put(root, now);
        while(root.next!=null) {
            root = root.next;
            now.next = new Node(root.val);
            map.put(root, now.next);
            now = now.next;
        }
        root = head;
        Node newRoot = newHead;
        while(root!=null) {
            Node ran = root.random;
            Node node = map.get(ran);
            newRoot.random = node;
            newRoot = newRoot.next;
            root = root.next;
        }
        return newHead;
    }



}
