package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 把二叉搜索树转换为累加树 {
    public TreeNode convertBST(TreeNode root) {
        recall(root, 0);
        return root;
    }

    public int recall(TreeNode root, int now) {
        if(root==null) return now;
        now = recall(root.right, now);
        root.val+=now;
        now = root.val;
        return recall(root.left, now);
    }
}
