package com.company.tree;

import com.company.common.TreeNode;

public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return getRoot(root,p,q);
    }

    public TreeNode getRoot(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val) {
            if(find(root.left,p,q)||find(root.right,p,q)) return root;
        }
        boolean left = find(root.left,p,q);
        boolean right = find(root.right,p,q);
        if(left && right) {
            return root;
        }
        if(left) {
            return getRoot(root.left,p,q);
        }else {
            return getRoot(root.right,p,q);
        }

    }

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return false;
        if(root.val==p.val||root.val==q.val) return true;
        else {
            boolean flag = find(root.left, p, q);
            if(!flag) {
                flag = find(root.right,p,q);
            }
            return flag;
        }
    }
}
