package com.company.tree;

import com.company.common.TreeNode;

import java.util.*;

public class 二叉树的锯齿形层次遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int time = 1;
        while(time!=0) {
            int item = 0;
            List<Integer> list = new ArrayList<>();
            while(time-->0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) {
                    item ++;
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    item ++;
                    queue.offer(node.right);
                }
            }
            time = item;
            res.add(list);
        }
        for(int i=0;i<res.size();i++) {
            if(i%2==1) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }
}
