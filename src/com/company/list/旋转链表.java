package com.company.list;

import com.company.common.ListNode;
import com.company.util.ArrayUtils;

public class 旋转链表 {

    public static void main(String[] args) {
        旋转链表 s = new 旋转链表();
        ListNode head = ArrayUtils.getNodeList(1,2,3);
        ArrayUtils.print(s.rotateRight(head, 2000000000));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode root = head;
        ListNode pre = null;
        ListNode wei = head;
        int time = 1;
        while(wei.next!=null) {
            pre = wei;
            wei = wei.next;
            time++;
        }
        k = k%time;
        while(k!=0) {
            k--;
            wei.next = root;
            pre.next = null;
            root = wei;
            wei = pre;

            pre = root;
            while(pre.next != wei) {
                pre = pre.next;
            }
        }
        return root;
    }
}
