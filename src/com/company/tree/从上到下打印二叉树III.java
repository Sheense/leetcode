package com.company.tree;

import com.company.common.TreeNode;

import java.util.*;

public class 从上到下打印二叉树III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int floor = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> item = new ArrayList<>();
            while(size--!=0) {
                TreeNode node = queue.poll();
                item.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            if(floor%2==1) {
                Collections.reverse(item);
            }
            floor++;
            res.add(item);
        }
        return res;
    }
}
