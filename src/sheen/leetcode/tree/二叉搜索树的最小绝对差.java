package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.Stack;

public class 二叉搜索树的最小绝对差 {
    public int getMinimumDifference(TreeNode root) {
        return find(root, new Stack<>());

    }

    public int find(TreeNode root, Stack<Integer> stack) {
        if(root==null) return Integer.MAX_VALUE;
        int min = find(root.left, stack);
        if(!stack.isEmpty()) {
            min = Math.min(min, root.val - stack.peek());
        }
        stack.push(root.val);
        min = Math.min(find(root.right, stack), min);
        return min;
    }
}
