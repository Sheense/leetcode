package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 二叉树中的最大路径和 {
    public static void main(String[] args) {
        二叉树中的最大路径和 s = new 二叉树中的最大路径和();
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.left = new TreeNode(-6);
        root.right.right.left.right = new TreeNode(-6);
        root.right.right.left.left.left = new TreeNode(-6);
        System.out.println(s.calculate(root));
    }
    public int maxPathSum(TreeNode root) {
        return calculate(root);
    }

    public int calculate(TreeNode root) {
        if(root.left==null&&root.right==null) {
            return root.val;
        }
        int left = Integer.MIN_VALUE;
        if(root.left!=null) {
            left = calculate(root.left);
        }
        int right = Integer.MIN_VALUE;
        if(root.right!=null) {
            right = calculate(root.right);
        }
        int res = root.val;
        root.val = Math.max(root.val,root.val+Math.max((root.left==null?0:root.left.val),(root.right==null?0:root.right.val)));
        if(root.right!=null&&root.right.val>=0) res+=root.right.val;
        if(root.left!=null&&root.left.val>=0) res+=root.left.val;
        return Math.max(res, Math.max(left, right));
    }

}
