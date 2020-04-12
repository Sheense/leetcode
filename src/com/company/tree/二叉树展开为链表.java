package com.company.tree;

import com.company.common.TreeNode;

public class 二叉树展开为链表 {

    public void flatten(TreeNode root) {
        build(root);
    }
    public TreeNode build(TreeNode root) {
        if(root==null) return null;
        TreeNode item = root.right;
        root.right = build(root.left);
        TreeNode node = root.right;
        while(node!=null&&node.right!=null) {
            node = node.right;
        }
        if(node==null) root.right = build(item);
        else node.right = build(item);
        root.left = null;
        return root;
    }
}
