package com.company.list;

import com.company.common.Node;

//430
public class 扁平化多级双向链表 {

    public Node flatten(Node head) {
        if(head==null) return null;
        getLast(head);
        return head;
    }
    public Node getLast(Node node) {
        Node res = null;
        Node first = node;
        Node second = node.next;
        do{
            if(first.child!=null) {
                first.next = first.child;
                Node child = first.child;
                child.prev = first;
                first.child = null;
                first = getLast(child);
            }
            first.next = second;
            Node tmp = second;
            if(second!=null) {
                second.prev = first;
                second = second.next;
            }
            res = first;
            first = tmp;
        }while(first!=null);
        return res;
    }

}
