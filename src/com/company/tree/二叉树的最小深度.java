package com.company.tree;

import com.company.common.TreeNode;

public class 二叉树的最小深度 {
    public static void main(String[] args) {
        二叉树的最小深度 s = new 二叉树的最小深度();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.minDepth(root));
    }
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return find(root,0,Integer.MAX_VALUE);
    }

    public int find(TreeNode root, int n, int min) {
        if(root.left == null && root.right == null) return Math.min(n+1, min);
        if(n+1>=min) return min;
        if(root.left!=null) {
            min = Math.min(find(root.left, n+1, min), min);
        }
        if(root.right != null) {
            min = Math.min(find(root.right, n+1, min), min);
        }
        return min;
    }




}
