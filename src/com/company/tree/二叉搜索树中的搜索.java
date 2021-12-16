package com.company.tree;

import com.company.common.TreeNode;

/**
 * @Classname 二叉搜索树中的搜索
 * @Date 2021/11/26 1:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) {
            return root;
        }

        if(root.val < val) {
            return searchBST(root.right, val);
        }

        if(root.val > val) {
            return searchBST(root.left, val);
        }

        return null;
    }
}
