package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 修剪二叉搜索树
 * @Date 2022/9/10 12:49 上午
 * @Created by sheen
 * @Description TODO
 */
public class 修剪二叉搜索树 {
    public static void main(String[] args) {
        修剪二叉搜索树 s = new 修剪二叉搜索树();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        s.trimBST(root, 1, 2);
    }
    private static TreeNode res;
    public TreeNode trimBST(TreeNode root, int low, int high) {
        res = root;
        recall(null, root, low, high);
        return res;
    }
    public void recall(TreeNode pre, TreeNode root, int low, int high) {
        if(root == null) return ;
        if(root.val < low) {
            if(pre==null) {
                res = root.right;
            }else {
                pre.left = root.right;
            }
            recall(pre, root.right, low, high);
            return;
        }



        if(root.val > high) {
            if(pre==null) {
                res = root.left;
            }else {
                pre.right = root.left;
            }
            recall(pre, root.left, low, high);
            return;
        }

        recall(root, root.left, low, high);
        recall(root, root.right, low, high);

    }
}
