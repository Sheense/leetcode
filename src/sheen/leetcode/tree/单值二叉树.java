package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 单值二叉树
 * @Date 2022/5/24 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 单值二叉树 {
    public boolean isUnivalTree(TreeNode root) {
        return recall(root, root.val);
    }

    public boolean recall(TreeNode root, int val) {
        if(root == null) {
            return true;
        }

        if(root.val != val) {
            return false;
        }

        return recall(root.left, val) && recall(root.right, val);
    }
}
