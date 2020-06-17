package com.company.tree;

import com.company.common.TreeNode;

import java.util.*;

public class 二叉树的序列化与反序列化 {
    public static class Codec {

        public static void main(String[] args) {
            TreeNode root = new TreeNode(-1);
            root.left = new TreeNode(0);
            root.right = new TreeNode(1);
            Codec c = new Codec();
            String string = c.serialize(root);
            System.out.println(string);
            c.deserialize(string);

        }
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return dfs(root);
        }
        public String dfs(TreeNode root) {
            if(root==null) return "X#";
            String res=root.val+"#";
            String left = dfs(root.left);
            String right = dfs(root.right);
            return res + left + right;
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] values = data.split("#");
            if(values.length==0) return null;
            Queue<String> queue = new LinkedList<>(Arrays.asList(values));
            return buildTree(queue, queue.poll());
        }
        public TreeNode buildTree(Queue<String> queue, String now) {
            if(now.equals("X")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(now));
            if(!queue.isEmpty()) root.left = buildTree(queue, queue.poll());
            if(!queue.isEmpty()) root.right = buildTree(queue, queue.poll());
            return root;
        }
    }
}


