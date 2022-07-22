package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

public class 链表的中间结点 {
    public static void main(String[] args) {
        链表的中间结点 s = new 链表的中间结点();

    }
    public ListNode middleNode(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
