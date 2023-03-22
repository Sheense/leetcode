package sheen.leetcode.dfs;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 二叉树着色游戏
 * @Date 2023/2/3 12:31 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二叉树着色游戏 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode target = find(root, x);
        int left = count(target.left);
        int right = count(target.right);
        int yu = n - left - right - 1;
        return left > (n - 1) / 2 || right > (n - 1) / 2 || yu > (n - 1) / 2;
    }

    public int count(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return count(root.left) + count(root.right) + 1;
    }

    public TreeNode find(TreeNode root, int x) {
        if(root == null) {
            return null;
        }

        TreeNode res = find(root.left, x);
        if(res != null) return res;
        if(root.val == x) {
            return root;
        }
        return find(root.right, x);
    }
}
