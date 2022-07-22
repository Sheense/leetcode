package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 二叉树的坡度
 * @Date 2021/11/18 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二叉树的坡度 {

    int res = 0;
    public int findTilt(TreeNode root) {
        recall(root);
        return res;
    }

    public int recall(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = recall(root.left);
        int right = recall(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
