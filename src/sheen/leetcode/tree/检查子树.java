package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 检查子树 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        preRecall(s1, t1);
        preRecall(s2, t2);
        return s1.toString().contains(s2.toString());
    }

    public void preRecall(StringBuilder sb, TreeNode root) {
        if(root == null) return ;
        preRecall(sb, root.left);
        sb.append(root.val + '#');
        preRecall(sb, root.right);
    }
}
