package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class 合法二叉搜索树 {
    public static void main(String[] args) {
        合法二叉搜索树 s = new 合法二叉搜索树();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(s.isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        return isSortTree(root, new ArrayList<>());
    }

    public boolean isSortTree(TreeNode root, List<Integer> now) {
        if(root == null) return true;
        boolean res = isSortTree(root.left, now);
        if(!res) return false;
        if(now.isEmpty()) {
            now.add(root.val);
        }
        else {
            if(now.get(now.size()-1) < root.val) {
                now.add(root.val);
            }else {
                return false;
            }
        }
        res = isSortTree(root.right, now);
        return res;
    }
}
