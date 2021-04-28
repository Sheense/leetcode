package com.company.tree;

import com.company.common.TreeNode;

public class 二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int res = 0;
        if (low <= root.val) {
            res += rangeSumBST(root.left, low, high);
        }
        if(root.val >= low && root.val <= high) {
            res += root.val;
        }else if (root.val > high) {
            return res;
        }
        res += rangeSumBST(root.right, low, high);
        return res;
    }
}
