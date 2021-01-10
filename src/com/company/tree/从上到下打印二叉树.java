package com.company.tree;

import com.company.common.TreeNode;

import java.util.*;

public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[]{};
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size--!=0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++) res[i] = list.get(i);
        return res;
    }
}
