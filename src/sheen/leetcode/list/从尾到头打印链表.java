package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        int n = 0;
        ListNode root = head;
        while(root!=null) {
            n++;
            root = root.next;
        }
        int [] res = new int[n];
        for(int i=0;i<n;i++) {
            res[n-i-1] = head.val;
            head = head.next;
        }
        return res;
    }
}
