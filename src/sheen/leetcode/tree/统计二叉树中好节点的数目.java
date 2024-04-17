package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 统计二叉树中好节点的数目
 * @Date 2023/8/25 00:23
 * @Created by sheen
 * @Description TODO
 */
public class 统计二叉树中好节点的数目 {
    public int goodNodes(TreeNode root) {
        return find(root, Integer.MIN_VALUE);
    }

    public int find(TreeNode root, int max) {
        if(root == null) {
            return 0;
        }
        int res = max <= root.val ? 1 : 0;
        max = Math.max(max, root.val);
        return res + find(root.left, max) + find(root.right, max);
    }
}
