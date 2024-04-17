package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

/**
 * @Classname 在链表中插入最大公约数
 * @Date 2024/1/6 03:11
 * @Created by sheen
 * @Description TODO
 */
public class 在链表中插入最大公约数 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            int god = god(Math.max(pre.val, next.val), Math.min(pre.val, next.val));
            ListNode newNode = new ListNode(god);
            pre.next = newNode;
            newNode.next = next;
            pre = next;
            next = next.next;
        }

        return head;
    }

    public int god(int a, int b) {
        if (b == 0) {
            return a;
        }

        return god(b, a % b);
    }
}
