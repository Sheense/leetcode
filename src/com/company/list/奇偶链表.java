package com.company.list;

import com.company.common.ListNode;
import com.company.util.ArrayUtils;


public class 奇偶链表 {
    public static void main(String[] args) {
        奇偶链表 s = new 奇偶链表();
        ArrayUtils.print(s.oddEvenList(ArrayUtils.getNodeList(2,1,3,5,6,4,7)));
    }

    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode j = null;
        ListNode j_now = null;
        ListNode o = null;
        ListNode o_now = null;
        int i =1;
        while(head!=null) {
            if(i%2==0) {
              if(o==null) {
                  o = head;
                  o_now = head;
              } else {
                  o_now.next = head;
                  o_now = o_now.next;
              }
            } else {
                if(j==null) {
                    j = head;
                    j_now = head;
                } else {
                    j_now.next = head;
                    j_now = j_now.next;
                }
            }
            head = head.next;
            i++;
        }
        j_now.next = o;
        o_now.next = null;
        return j;
    }
}
