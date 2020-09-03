package com.company.tree;

import com.company.common.TreeNode;

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        reback(root);
        return root;
    }

    public void reback(TreeNode root) {
        if(root== null) return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        reback(root.left);
        reback(root.right);
    }
}
