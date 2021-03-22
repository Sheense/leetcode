package com.company.stack;

import com.company.common.ListNode;

import java.util.Stack;

public class 链表中的下一个更大节点 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head!=null) {
            stack.push(head);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        Stack<Integer> min = new Stack<>();
        for(int i=res.length-1;i>=0;i--) {
            ListNode node = stack.pop();
            while(!min.isEmpty()&&min.peek()<=node.val) {
                min.pop();
            }
            res[i] = min.isEmpty() ? 0 : min.peek();
            min.push(node.val);
        }
        return res;
    }
}
