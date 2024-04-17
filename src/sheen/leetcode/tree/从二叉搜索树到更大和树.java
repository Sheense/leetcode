package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 从二叉搜索树到更大和树
 * @Date 2023/12/4 00:10
 * @Created by sheen
 * @Description TODO
 */
public class 从二叉搜索树到更大和树 {
    public TreeNode bstToGst(TreeNode root) {
        recall(root, 0);
        return root;
    }

    public int recall(TreeNode root, int val) {
        if(root == null) {
            return val;
        }
        int res = recall(root.right, val);
        root.val += res;
        return recall(root.left, root.val);
    }
}
