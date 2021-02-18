package com.company.list;

import com.company.common.ListNode;

import java.util.Stack;

public class 回文链表 {

    public static void main(String[] args) {
        回文链表 s = new 回文链表();
        ListNode root= new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        System.out.println(s.isPalindrome(root));
    }
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode root = head;
        while(root!=null) {
            stack.push(root.val);
            root = root.next;
        }
        root = head;
        while(!stack.isEmpty()) {
            if(stack.pop()!=root.val) {
                return false;
            }
            root = root.next;
        }
        return true;
    }
    /*public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        int num = 0;
        ListNode root= head;
        while(root!=null) {
            root = root.next;
            num++;
        }
        root = head;
        int n = num/2;
        while(n-->0) {
            root = root.next;
            if(n==0) {
                ListNode node = reback(root);
                int count = num/2;
                while(count-->0) {
                    if(node.val!=head.val) {
                        return false;
                    }
                    node = node.next;
                    head = head.next;
                }
                return true;
            }
        }
        return false;
    }

    public ListNode reback(ListNode node) {
        ListNode next = null;
        while(node!=null) {
            ListNode last = node.next;
            node.next = next;
            next = node;
            node = last;
        }
        return next;
    }*/
}
