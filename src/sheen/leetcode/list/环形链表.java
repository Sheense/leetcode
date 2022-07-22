package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

public class 环形链表 {


    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode fast = head.next.next;
        ListNode snow = head.next;
        while(fast!=snow) {
            if(fast==null||fast.next==null) return false;
            fast = fast.next.next;
            snow = snow.next;
        }
        return true;
    }
}
