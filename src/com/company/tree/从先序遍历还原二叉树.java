package com.company.tree;

import com.company.common.TreeNode;

import java.util.*;

public class 从先序遍历还原二叉树 {

    public static void main(String[] args) {
        从先序遍历还原二叉树  s = new 从先序遍历还原二叉树();
        s.recoverFromPreorder("1-2--3--4-5--6--7");
    }
    public TreeNode recoverFromPreorder(String S) {
        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<S.length();i++) {
            queue.offer(S.charAt(i));
        }
        return buildTree(queue, 0);
    }

    public TreeNode buildTree(Queue<Character> queue, int time) {
        if(queue.isEmpty()) return null;
        TreeNode node = null;
        int k = 0;
        Iterator<Character> iter = queue.iterator();
        while(iter.hasNext()) {
            char c = iter.next();
            if(c=='-') k++;
            else break;
        }
        if(k==time) {
            while(k!=0) {
                queue.poll();
                k--;
            }
            int val = 0;
            while(!queue.isEmpty()&&queue.peek()!='-') {
                val*=10;
                val+=queue.poll()-'0';
            }
            node = new TreeNode(val);
            node.left = buildTree(queue, time+1);
            node.right = buildTree(queue, time+1);
        }
        return node;
    }
}
