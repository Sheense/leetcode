package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 最深叶节点的最近公共祖先
 * @Date 2023/9/6 00:03
 * @Created by sheen
 * @Description TODO
 */
public class 最深叶节点的最近公共祖先 {
    private TreeNode res = null;
    private int maxDeep = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        最深叶节点的最近公共祖先 s = new 最深叶节点的最近公共祖先();
        System.out.println(s.lcaDeepestLeaves(root));
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        recall(root, 1);
        return res == null ? root : res;
    }

    public int recall(TreeNode root, int deep) {

        int left = deep;
        if(root.left != null) {
            left = recall(root.left, deep + 1);
        }
        int right = deep;
        if(root.right != null) {
            right = recall(root.right, deep + 1);
        }
        if(root.left != null && root.right != null && left == right && maxDeep <= left) {
            maxDeep = left;
            res = root;
        }
        return Math.max(left, right);
    }
}
