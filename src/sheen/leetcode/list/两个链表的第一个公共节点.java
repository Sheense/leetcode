package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

/**
 * @Classname 个链表的第一个公共节点
 * @Date 2021/7/21 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = 0;
        int count2 = 0;
        ListNode root1 = headA;
        ListNode root2 = headB;
        while (root1 != null) {
            count1++;
            root1 = root1.next;
        }
        while (root2 != null) {
            count2++;
            root2 = root2.next;
        }
        root1 = headA;
        root2 = headB;
        int yu = count1 - count2;
        if(yu > 0) {
            while (yu-- != 0) {
                root1 = root1.next;
            }
        }else {
            while (yu++ != 0) {
                root2 = root2.next;
            }
        }

        while (root1!=null && root2 != null) {
            if(root1 == root2) return root1;
            root1 = root1.next;
            root2 = root2.next;
        }
        return null;
    }
}
