package com.company.tree;

import com.company.common.TreeNode;

import java.util.*;

public class 叶子相似的树 {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> str1 = getLeafs(root1);
        List<Integer> str2 = getLeafs(root2);
        if(str1.size() != str2.size()) return false;
        for(int i=0;i<str1.size();i++) {
            if(str1.get(i) != str2.get(i)) return false;
        }
        return true;
    }

    public List<Integer> getLeafs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
            TreeNode node = stack.pop();
            if(node.right == null) {
                res.add(node.val);
            }
            while (!stack.isEmpty() && node.right == null) {
                node = stack.pop();
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }
}
