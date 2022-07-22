package sheen.leetcode.list;

import sheen.leetcode.common.ListNode;

public class 两数相加 {
    public static void main(String[] args) {
        两数相加 s = new 两数相加();


    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root1 = l1;
        ListNode root2 = l2;
        ListNode res = null;
        ListNode now = null;
        int carry = 0;
        while(root1!=null||root2!=null||carry==1) {
            if(root1==null||root2==null) {
                if(root1==null&&root2==null) {
                    if(carry==1) now.next = new ListNode(1);
                    break;
                }
                if(root1==null) {
                    now.next = root2;
                    now = root2;
                } else {
                    now = root1;
                }
                while(carry==1) {
                    int v = now.val+carry;
                    if(v>=10) {
                        carry = 1;
                        v = v%10;
                    } else {
                        carry = 0;
                    }
                    now.val = v;
                    if(now.next==null&&carry==1) {
                        now.next = new ListNode(1);
                        carry = 0;
                    }
                    now = now.next;
                }
                break;
            }
            int v = root1.val + root2.val+carry;
            if(v>=10){
                carry = 1;
                v %= 10;
            } else{
                carry = 0;
            }
            root1.val = v;
            if(res==null) {
                res = root1;
            }
            now = root1;
            root1 = root1.next;
            root2 = root2.next;
        }
        return res;
    }
}
