package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.util.ArrayUtils;

public class 链表求和 {

    public static void main(String[] args) {
        链表求和 s = new 链表求和();
        ListNode l1 = ArrayUtils.getNodeList(7,1,7,9,9,9,9,9);
        ListNode l2 = ArrayUtils.getNodeList(5,9,2);
        ArrayUtils.print(s.addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = l1;
        int jin = 0;
        while(l1.next!=null&&l2.next!=null) {
            int value = l1.val + l2.val + jin;
            jin = value/10;
            value %= 10;
            l1.val = value;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1.next==null) {
            int value = l1.val + l2.val + jin;
            jin = value/10;
            value = value%10;
            l1.val = value;
            if(jin==1&&l2.next==null) {
                l1.next = new ListNode(1);
            } else if(jin==1&&l2.next!=null){
                l1.next = l2.next;
                l1 = l1.next;
                while(jin!=0) {
                    value = l1.val + jin;
                    jin = value/10;
                    value = value%10;
                    l1.val = value;
                    if(l1.next==null&&jin==1) {
                        l1.next = new ListNode(1);
                        jin = 0;
                    }
                    l1 = l1.next;
                }
            }else {
                l1.next = l2.next;
            }
        }else {
            int value = l1.val + l2.val + jin;
            jin = value/10;
            value = value%10;
            l1.val = value;
            if(l1.next==null&&jin==1) {
                l1.next = new ListNode(jin);
            }else {
                l1 = l1.next;
                while(jin!=0) {
                    value = l1.val + jin;
                    jin = value/10;
                    value = value%10;
                    l1.val = value;
                    if(l1.next==null&&jin==1) {
                        l1.next = new ListNode(1);
                        jin = 0;
                    }
                    l1 = l1.next;
                }
            }

        }
        return sum;
    }
}
