package sheen.leetcode.tree;

import sheen.leetcode.common.ListNode;
import sheen.leetcode.common.TreeNode;

public class 二叉树中的列表 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;
        if(head == null) return true;
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean dfs(TreeNode root, ListNode head) {
        if(head == null) return true;
        if(root == null) return false;
        if(root.val!=head.val) {
            return false;
        }
        return dfs(root.left, head.next) || dfs(root.right, head.next);
    }

}
