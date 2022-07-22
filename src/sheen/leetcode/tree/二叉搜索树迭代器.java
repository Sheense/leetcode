package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;


import java.util.Stack;

public class 二叉搜索树迭代器 {
    class BSTIterator {

        private Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            TreeNode node =root;
            while(node!=null) {
                stack.push(node);
                node = node.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            TreeNode n = node.right;
            while(n!=null) {
                stack.push(n);
                n = n.left;
            }
            return node.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
