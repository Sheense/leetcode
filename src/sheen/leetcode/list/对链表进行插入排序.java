package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

public class 对链表进行插入排序 {

    public static void main(String[] args) {
        对链表进行插入排序 s = new 对链表进行插入排序();
        ArrayUtils.print(s.insertionSortList(ArrayUtils.getNodeList(-1)));
    }
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode root = head;
        ListNode now = head.next;
        ListNode pre_now = head;
        while(now!=null) {
            ListNode pre = null;
            ListNode item = root;
            while(item.val<now.val) {
                pre = item;
                item = item.next;
            }
            if(item==now) {
                pre_now = now;
                now = now.next;
                continue;
            }
            pre_now.next = now.next;
            if(pre==null) {
                now.next = root;
                root = now;
            }else {
                ListNode node = pre.next;
                pre.next = now;
                now.next = node;
            }
            now = pre_now.next;
        }
        return root;
    }
}
