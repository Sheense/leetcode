package com.company.tree;


import java.util.Stack;

public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        Node node = new Node();
        node.val = 8;
        node.left = new Node();
        node.left.val = -6;
        node.right = new Node();
        node.right.val = 7;
        node.left.left = new Node();
        node.left.left.val = -8;
        node.left.right = new Node();
        node.left.right.val = 10;
        二叉搜索树与双向链表 s = new 二叉搜索树与双向链表();
        //s.treeToDoublyList(node);
        s.mid(node);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node head = null;
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        stack.push(root);
        while(!stack.isEmpty()) {
            while(stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
            Node node = stack.pop();
            if(head == null) head = node;
            if (pre != null) {
                pre.right = node;
                node.left = pre;
            }
            pre = node;

            while (!stack.isEmpty()&&pre.right == null) {
                Node last = stack.pop();
                pre.right = last;
                last.left = pre;
                pre = last;
            }
            if (pre.right != null) {
                stack.push(pre.right);
            }
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
//后续遍历
    public void print(Node root) {
        Stack<Node> stark = new Stack<>();
        Stack<Node> res = new Stack<>();
        stark.push(root);
        while(!stark.isEmpty()) {
            Node node = stark.pop();
            res.push(node);
            if(node.left!=null) {
                stark.push(node.left);
            }
            if(node.right!=null) {
                stark.push(node.right);
            }
        }
        while (!res.isEmpty()) System.out.println(res.pop().val);
    }
//前序遍历
    public void first(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.println(n.val);
            if(n.right!=null){
                stack.push(n.right);
            }
            if(n.left!=null) {
                stack.push(n.left);
            }
        }
    }
    //中序遍历
    public void mid(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            while (stack.peek().left!=null) {
                stack.push(stack.peek().left);
            }
            Node node = stack.pop();
            System.out.println(node.val);
            while(!stack.isEmpty()&&node.right==null) {
                node = stack.pop();
                System.out.println(node.val);
            }
            if(node.right!=null) {
                stack.push(node.right);
            }
        }
    }
}
