package com.company.list;

import com.company.common.ListNode;

public class 二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        if(head == null) return 0;
        int res = head.val;
        while(head.next!=null) {
            res <<= 1;
            res += head.next.val;
            head = head.next;
        }
        return res;
    }
}
