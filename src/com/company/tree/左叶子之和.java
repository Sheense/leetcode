package com.company.tree;

import com.company.common.TreeNode;

public class 左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        int val = 0;
        if(root == null) return val;
        TreeNode left = root.left;
        if(left!=null&&left.left==null&&left.right==null){
            val += left.val;
        }else if(left!=null) {
            val+=sumOfLeftLeaves(left);
        }
        if(root.right!=null) {
            val+=sumOfLeftLeaves(root.right);
        }
        return val;
    }


}
