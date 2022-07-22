package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

public class 链表相交 {

    public static void main(String[] args) {
        链表相交 s = new 链表相交();
        ArrayUtils.print(s.getIntersectionNode(ArrayUtils.getNodeList(4,1,8,4,5),ArrayUtils.getNodeList(5,0,1,8,4,5)));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        int len1 = 0;
        int len2 = 0;
        ListNode rootA = headA;
        ListNode rootB = headB;
        while(rootA!=null||rootB!=null){
            if(rootA!=null) {
                len1++;
                rootA = rootA.next;
            }
            if(rootB!=null) {
                len2++;
                rootB = rootB.next;
            }
        }
        if(len1>len2) {
            int len = len1-len2;
            while(len!=0) {
                headA = headA.next;
                len --;
            }
        }else {
            int len = len2-len1;
            while(len!=0) {
                headB = headB.next;
                len --;
            }
        }
        while(headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
