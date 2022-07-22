package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 检查平衡性 {
    public boolean isBalanced(TreeNode root) {
        return isAVL(root).contains("true");
    }

    public String isAVL(TreeNode root) {
        if(root == null) return "0&true";
        String left = isAVL(root.left);
        if(left.contains("false")) return "0&false";
        String right = isAVL(root.right);
        if(right.contains("false")) return "0&false";
        int leftHeight = Integer.valueOf(left.split("&")[0]);
        int rightHeight = Integer.valueOf(right.split("&")[0]);
        boolean isAVL = Math.abs(rightHeight - leftHeight) <= 1;
        return (Math.max(rightHeight, leftHeight) + 1) + "&" + isAVL;
    }

}
