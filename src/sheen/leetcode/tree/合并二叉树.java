package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null) return null;
        int val1 = t1==null?0:t1.val;
        int val2 = t2==null?0:t2.val;
        TreeNode left1 = t1==null?null:t1.left;
        TreeNode left2 = t2==null?null:t2.left;
        TreeNode left = mergeTrees(left1,left2);
        TreeNode right1 = t1==null?null:t1.right;
        TreeNode right2 = t2==null?null:t2.right;
        TreeNode right = mergeTrees(right1,right2);
        TreeNode node = new TreeNode(val1+val2);
        node.left = left;
        node.right = right;
        return node;
    }
}
