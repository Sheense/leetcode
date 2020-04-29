package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root==null) return res;
        recall(root, res, "");
        return res;
    }

    public void recall(TreeNode root, List<String> res, String now) {
        now = now + root.val;
        if(root.left==null && root.right==null) {
            res.add(now);
        } else if(root.left==null) {
            now += "->";
            recall(root.right, res, now);
        } else if(root.right==null) {
            now += "->";
            recall(root.left, res, now);
        } else {
            now += "->";
            recall(root.right, res, now);
            recall(root.left, res, now);
        }
    }
}
