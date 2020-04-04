package com.company.list;

import com.company.common.ListNode;
import com.company.util.ArrayUtils;

public class 重排链表 {
    public static void main(String[] args) {
        ListNode root = ArrayUtils.getNodeList(1,2,3,4,5,6,7,8,9,10);
        重排链表 s = new 重排链表();
        s.reorderList(root);
        ArrayUtils.print(root);
    }
    public void reorderList(ListNode head) {
        ListNode root = head;
        ListNode wei = head;
        while(wei!=null&&wei.next!=null){
            while(wei.next.next!=null) wei = wei.next;
            ListNode item = wei;
            wei = wei.next;
            item.next = null;
            ListNode r = root.next;
            root.next = wei;
            wei.next = r;
            root = r;
            wei = r;
        }
    }
}
