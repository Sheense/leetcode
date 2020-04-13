package com.company.list;

import com.company.common.ListNode;
import com.company.util.ArrayUtils;



public class 两数相加II {
    public static void main(String[] args) {
        ListNode l1 = ArrayUtils.getNodeList(3);
        ListNode l2 = ArrayUtils.getNodeList(4);
        两数相加II s = new 两数相加II();
        ArrayUtils.print(s.addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return l1==null?l2:l1;
        int length1 = 0;
        int length2 = 0;
        ListNode item1 = l1;
        ListNode item2 = l2;
        while(item1!=null||item2!=null) {
            if(item1!=null) {
                length1++;
                item1 = item1.next;
            }
            if(item2!=null) {
                length2++;
                item2 = item2.next;
            }
        }
        if(length1!=length2) {
            return getRoot( l1, length1, l2, length2);
        }else {
            ListNode a = l1;
            ListNode b = l2;
            ListNode next = recall(a,  b);
            if(next.val>=10) {
                next.val %=10;
                ListNode root = new ListNode(1);
                root.next = next;
                return root;
            }else {
                return next;
            }
        }
    }

    public ListNode getRoot(ListNode a, int length1, ListNode b, int length2) {
        ListNode max = length2>length1?b:a;
        ListNode min = length2>length1?a:b;
        int time = length2>length1?length2-length1-1:length1-length2-1;
        while(time--!=0) {
            max = max.next;
        }
        ListNode next = recall(max.next,  min);
        if(next.val>=10) {
            next.val %=10;
            max.val +=1;
            ListNode pre = length1>length2?a:b;
            ListNode root = findRoot(pre, max);
            if(root.val>=10) {
                ListNode node = new ListNode(1);
                root.val %=10;
                node.next = root;
                return node;
            }
            return root;
        }else {
            max.next = next;
            return length2>length1?b:a;
        }
    }

    public ListNode findRoot(ListNode root, ListNode target) {
        if(root==target) {
            return root;
        }else {
            ListNode next = findRoot(root.next,target);
            if(next.val>=10) {
                next.val %= 10;
                root.val +=1;
            }
            return root;
        }
    }

    public ListNode recall(ListNode a, ListNode b) {
        if(a.next==null&&b.next==null) {
            a.val += b.val;
            return a;
        }else {
            ListNode next = recall(a.next,b.next);
            if(next.val>=10) {
                next.val %=10;
                a.val +=1;
            }
            a.val += b.val;
            return a;
        }
    }
}
