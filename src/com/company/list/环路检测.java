package com.company.list;

import com.company.common.ListNode;

public class 环路检测 {

    public static void main(String[] args) {
        环路检测 s = new 环路检测();
        System.out.println(s.detectCycle(new ListNode(1)).val);
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast!=null&&fast.next!=null&&fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast==null||fast.next==null) {
            return null;
        }
        while(head!=slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;

    }
}
