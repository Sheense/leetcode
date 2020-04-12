package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        for(int i=0;i<res.size()/2;i++) {
            List<Integer> item = res.get(i);
            res.set(i, res.get(res.size()-1-i));
            res.set(res.size()-1-i, item);
        }
        return res;
    }
}
