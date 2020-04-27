package com.company.list;

import com.company.common.ListNode;

public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        int length1 = 0;
        int length2 = 0;
        ListNode root1 = headA;
        ListNode root2 = headB;
        while(root1!=null||root2!=null) {
            if(root1!=null) {
                length1++;
                root1 = root1.next;
            }
            if(root2!=null) {
                length2++;
                root2 = root2.next;
            }
        }
        if(length1>length2) {
            int n = length1-length2;
            while(n!=0) {
                headA = headA.next;
                n--;
            }
        } else {
            int n = length2-length1;
            while(n!=0) {
                headB = headB.next;
                n--;
            }
        }
        while(headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
