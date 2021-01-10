package com.company.list;

import com.company.common.ListNode;
import com.company.util.ArrayUtils;

public class 交换链表中的节点 {
    public static void main(String[] args) {
        交换链表中的节点 s = new 交换链表中的节点();
        ArrayUtils.print(s.swapNodes(ArrayUtils.getNodeList(7,9),1));
    }
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        int length = 0;
        ListNode root = head;
        while(root!=null) {
            length++;
            root = root.next;
        }
        if(k>length/2) {
            k = length-k+1;
        }
        ListNode preFirst = null;
        ListNode first = null;
        ListNode preSecond = null;
        ListNode second = null;

        ListNode pre = null;
        ListNode now = head;
        int count = 1;
        while(now!=null) {
            if(count==k) {
                preFirst = pre;
                first = now;
            }
            if(length-k+1==count) {
                preSecond = pre;
                second = now;
            }
            pre = now;
            now = now.next;
            count++;
        }
        if(first==second) {
            return head;
        } else if(preFirst==null) {
            if(preSecond==first) {
                first.next=second.next;
                second.next = first;
            }else {
                second.next = first.next;
                first.next=null;
                preSecond.next = first;
            }
            return second;
        }else if(preSecond==first){
            preFirst.next = second;
            first.next = second.next;
            second.next = first;
            return head;
        }else {
            preFirst.next = second;
            ListNode seconddNext = second.next;
            second.next = first.next;
            first.next = seconddNext;
            preSecond.next = first;
            return head;
        }
    }
}
