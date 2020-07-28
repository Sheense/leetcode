package com.company.tree;

import com.company.common.TreeNode;

public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
