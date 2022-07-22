package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

public class 合并两个有序链表 {

    public static void main(String[] args) {
        合并两个有序链表 s = new 合并两个有序链表();
        ArrayUtils.print(s.mergeTwoLists(ArrayUtils.getNodeList(1,2,4),ArrayUtils.getNodeList(1,3,4)));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode now = null;
        if(l1==null&&l2==null){
            return null;
        } else if(l1==null||l2==null){
            root = l1==null?l2:l1;
            return root;
        }else if(l1.val<=l2.val) {
            root = l1;
            now = l1;
            l1 = l1.next;
        }else {
            root = l2;
            now = l2;
            l2 = l2.next;
        }

        while(l1!=null&&l2!=null) {
            if(l1.val<l2.val) {
                now.next = l1;
                now = now.next;
                l1 = l1.next;
            }else {
                now.next = l2;
                now = now.next;
                l2 = l2.next;
            }
        }
        if(l1==null) now.next = l2;
        else now.next = l1;
        return root;
    }
}
