package com.company.list;

import com.company.common.ListNode;
import com.company.util.ArrayUtils;
//86
public class 分隔链表 {

    public static void main(String[] args) {
        分隔链表 s = new 分隔链表();
        ArrayUtils.print(s.partition(ArrayUtils.getNodeList(1,4,3,2,5,2),0));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode less_first = null;
        ListNode less_wei = null;
        ListNode more_first = null;
        ListNode more_wei = null;

        while (head!=null) {
            if(head.val<x) {
                if(less_first==null) {
                    less_first = head;
                    less_wei = head;
                }
                else {
                    less_wei.next = head;
                    less_wei = head;
                }
            }else if(head.val>=x) {
                if(more_first==null) {
                    more_first = head;
                    more_wei = head;
                }
                else {
                    more_wei.next = head;
                    more_wei = head;
                }
            }
            head = head.next;
        }
        ListNode root = null;
        if(less_first!=null) {
            root = less_first;
            less_wei.next = more_first;
            if(more_wei!=null) more_wei.next = null;
        }else {
            root = more_first;
        }
        return root;
    }
}
