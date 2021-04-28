package com.company.tree;

import com.company.common.TreeNode;

public class BiNode {

    public static void main(String[] args) {
        BiNode s = new BiNode();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(0);
        s.convertBiNode(root);
    }
    TreeNode head = null;
    public TreeNode convertBiNode(TreeNode root) {
        build(root, null);
        return head;
    }

    public TreeNode build(TreeNode root, TreeNode pre) {
        if (root == null) return pre;
        pre = build(root.left, pre);
        if(head == null) {
            head = root;
            pre = root;
        }else {
            pre.right = root;
            pre = root;
            root.left = null;
        }
        pre = build(root.right, pre);
        return pre;
    }

}
