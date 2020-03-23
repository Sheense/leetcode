package com.company.list;

import com.company.common.ListNode;

public class 两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head.next;
        do {
            ListNode tmp = fast.next;
            fast.next = slow;
            slow.next = tmp;
            if(pre!=null)pre.next = fast;
            else head = fast;
            pre = slow;
            slow = tmp;
            fast = tmp!=null?tmp.next:null;
        }while (slow !=null &&fast!=null);
        return head;
    }
}
