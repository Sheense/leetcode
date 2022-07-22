package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(root.val>=val){
            if(left==null) {
                TreeNode node = new TreeNode(val);
                root.left = node;
            }else {
                insertIntoBST(left, val);
            }
        }else {
            if(right==null) {
                TreeNode node = new TreeNode(val);
                root.right = node;
            }else {
                insertIntoBST(right, val);
            }
        }
        return root;
    }
}
