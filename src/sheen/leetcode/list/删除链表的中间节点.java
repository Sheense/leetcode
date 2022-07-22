package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

/**
 * @Classname 删除链表的中间节点
 * @Date 2021/12/5 11:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 删除链表的中间节点 {

    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
