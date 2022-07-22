package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode root = head;
        ListNode pre = null;
        while(root!=null) {
            ListNode node = root.next;
            root.next = pre;
            pre = root;
            if(node==null) head = root;
            root = node;
        }
        return head;
    }
}
