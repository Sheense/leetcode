package com.company.tree;

import com.company.common.TreeNode;

import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的右视图 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        二叉树的右视图 s = new 二叉树的右视图();
        System.out.println(s.rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size()!=0) {
            int size = queue.size();
            TreeNode node = null;
            while(size!=0) {
                node = queue.poll();
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
                size--;
            }
            res.add(node.val);
        }
        return res;
    }
}
