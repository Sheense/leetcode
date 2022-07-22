package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

public class 移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode now = head;
        ListNode root = head;
        while(now != null) {
            if(now.val == val) {
                if(pre==null) {
                    root = root.next;
                    now = now.next;
                }else {
                    pre.next = now.next;
                    now = now.next;
                }
            }else {
                pre = now;
                now = now.next;
            }
        }
        return root;
    }
}
