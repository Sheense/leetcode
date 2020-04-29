package com.company.tree;

import com.company.common.TreeNode;

public class 求根到叶子节点数字之和 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        求根到叶子节点数字之和 s = new 求根到叶子节点数字之和();
        System.out.println(s.sumNumbers(node));
    }

    public int sumNumbers(TreeNode root) {
        return add(root, 0);
    }

    public int add(TreeNode root, int num) {
        if(root==null) return num;
        num = num * 10 + root.val;
        if(root.left==null&&root.right==null)  return num;
        else if(root.left==null) {
            return add(root.right, num);
        }else if(root.right == null) {
            return add(root.left, num);
        }else {
            return add(root.left, num) + add(root.right, num);
        }
    }
}
