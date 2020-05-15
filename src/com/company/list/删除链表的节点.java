package com.company.list;

import com.company.common.ListNode;

public class 删除链表的节点 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode root = head;
        ListNode pre = null;
        while(true) {
            if(root.val==val) {
                if(root==head) return head.next;
                pre.next = root.next;
                return head;
            }
            pre = root;
            root = root.next;
        }
    }
}
