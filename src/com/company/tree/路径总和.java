package com.company.tree;

import com.company.common.TreeNode;
import com.company.util.ArrayUtils;

import java.util.Arrays;

public class 路径总和 {

    public static void main(String[] args) {
        路径总和 s = new 路径总和();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        System.out.println(s.hasPathSum(root, 1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        int num = sum - root.val;
        if(num==0&&root.right==null&&root.left==null){
            return true;
        }
        if(root.left!=null) {
            boolean a = hasPathSum(root.left, num);
            if(a) return true;
        }
        if(root.right!=null) {
            boolean a = hasPathSum(root.right, num);
            if(a) return true;
        }
        return false;
    }
}
