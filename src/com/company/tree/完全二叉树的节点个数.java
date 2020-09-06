package com.company.tree;

import com.company.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            res += size;
            while(size-->0) {
                TreeNode node = queue.poll();
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
