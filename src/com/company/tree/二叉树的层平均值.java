package com.company.tree;

import com.company.common.TreeNode;
import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int count = size;
            double all = 0;
            while(size-->0) {
                TreeNode node = queue.poll();
                all += node.val;
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            res.add(all/count);
        }
        return res;
    }
}
