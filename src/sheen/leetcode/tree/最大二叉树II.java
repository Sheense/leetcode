package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 最大二叉树II
 * @Date 2022/8/30 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大二叉树II {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        recall(root, val);

        return root;
    }

    public void recall(TreeNode root, int val) {
        if(root == null) return ;

        if(root.val > val && (root.right == null || root.right.val < val)) {
            TreeNode right = root.right;
            TreeNode node = new TreeNode(val);
            node.left = right;
            root.right = node;
            return;
        }

        recall(root.right, val);
    }
}
