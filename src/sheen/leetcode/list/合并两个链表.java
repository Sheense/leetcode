package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

public class 合并两个链表 {
    public static void main(String[] args) {
        合并两个链表 s = new 合并两个链表();
        ArrayUtils.print(s.mergeInBetween(ArrayUtils.getNodeList(0,1,2,3,4,5),0,2,ArrayUtils.getNodeList(1000000,1000001,1000002)));
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode preA = null;
        ListNode nextB = null;
        ListNode root = list1;
        int num = 0;
        while(num!=a) {
            preA = root;
            root = root.next;
            num++;
        }
        while(num!=b) {
            root = root.next;
            num++;
        }
        nextB = root.next;
        preA.next = list2;
        while(list2.next!=null) {
            list2 = list2.next;
        }
        list2.next = nextB;
        return list1;
    }
}
