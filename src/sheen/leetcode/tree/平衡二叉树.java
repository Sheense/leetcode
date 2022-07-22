package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        int res = height(root);
        return res != -1;
    }

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        if(left==-1) return -1;
        int right = height(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right)>=2) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
