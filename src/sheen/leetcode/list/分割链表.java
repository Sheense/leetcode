package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

public class 分割链表 {

    public static void main(String[] args) {
        ListNode root = ArrayUtils.getNodeList(1);
        分割链表 s = new 分割链表();
        ArrayUtils.print(s.partition(root, 3));
    }
    public ListNode partition(ListNode head, int x) {
        ListNode less =null;
        ListNode more = null;
        ListNode moreHead = null;
        ListNode lessHead = null;
        while(head!=null) {
            if(head.val<x) {
                if(less==null) {
                    less = head;
                    lessHead = head;
                }
                else {
                    less.next = head;
                    less = less.next;
                }
            }else {
                if(more==null) {
                    more = head;
                    moreHead = head;
                }
                else {
                    more.next = head;
                    more = more.next;
                }
            }

            head = head.next;
        }
        if(lessHead==null) return moreHead;
        else {
            less.next = moreHead;
            if(more!=null)more.next = null;
            return lessHead;
        }
    }
}
