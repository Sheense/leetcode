package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.Stack;

public class 二叉搜索树中第K小的元素 {

    public static void main(String[] args) {
        二叉搜索树中第K小的元素 s = new 二叉搜索树中第K小的元素();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(s.kthSmallest(root, 3));
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            if(stack.peek().left==null) {
                k--;
                TreeNode node = stack.pop();
                if(k==0) return node.val;
                if(node.right!=null) {
                    stack.push(node.right);
                }else {
                    while(!stack.isEmpty()&&stack.peek().right==null) {
                        k--;
                        node = stack.pop();
                        if(k==0) return node.val;
                    }
                    if(stack.isEmpty()) break;
                    else {
                        k--;
                        node = stack.pop();
                        if(k==0) return node.val;
                        stack.push(node.right);
                    }
                }
            }else {
                stack.push(stack.peek().left);
            }
        }
        return root.val;
    }
}
