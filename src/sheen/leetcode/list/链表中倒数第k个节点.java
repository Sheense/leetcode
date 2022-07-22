package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

public class 链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head;
        ListNode right = null;
        int i = 0;
        while(head!=null&&i!=k) {
            right = head;
            i++;
            head = head.next;
        }
        while(right.next!=null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
