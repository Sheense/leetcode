package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 二叉树剪枝
 * @Date 2022/7/21 12:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二叉树剪枝 {
    public TreeNode pruneTree(TreeNode root) {
        boolean res = recall(root);
        if(res) {
            return root;
        }
        return null;
    }

    public boolean recall(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean res = root.val == 1;
        boolean a = recall(root.left);
        if(!a) {
            root.left = null;
        }
        boolean b = recall(root.right);
        if(!b) {
            root.right = null;
        }
        return a || b || res;
    }
}
