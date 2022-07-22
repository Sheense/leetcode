package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

public class 反转链表II {

    public static void main(String[] args) {
        ListNode head = ArrayUtils.getNodeList(1,1);
        反转链表II s = new 反转链表II();
        ArrayUtils.print(s.reverseBetween(head, 1,1));
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int time = n - m;
        ListNode pre = null;
        ListNode now = head;
        while(time!=0) {
            if(m==1) {
                ListNode w = now;
                ListNode last = now.next;
                ListNode h1 = null;
                while(--time>=0) {
                    ListNode item = last.next;
                    last.next = now;
                    if(time==0) h1 = last;
                    now = last;
                    last = item;
                }
                w.next = last;
                if(pre!=null) pre.next = h1;
                else return h1;
                break;
            }
            m--;
            pre = now;
            now = now.next;
        }
        return head;
    }
}
