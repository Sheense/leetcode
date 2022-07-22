package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 递增顺序搜索树 {
    public TreeNode increasingBST(TreeNode root) {
        bulid(root, null).right = null;

        return head;
    }
    TreeNode head = null;
    public TreeNode bulid(TreeNode root, TreeNode last) {
        if(root == null) return last;
        last = bulid(root.left, last);
        root.left = null;
        if(last == null) {
            head = root;
            last = root;
        }else {
            last.right = root;
            last = last.right;
        }
        last = bulid(root.right, last);
        return last;
    }
}
