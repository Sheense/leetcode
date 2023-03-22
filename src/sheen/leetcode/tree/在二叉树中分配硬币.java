package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 在二叉树中分配硬币
 * @Date 2023/3/22 3:27 下午
 * @Created by sheen
 * @Description TODO
 */
public class 在二叉树中分配硬币 {
    private int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val - 1 + left + right;
    }


}
