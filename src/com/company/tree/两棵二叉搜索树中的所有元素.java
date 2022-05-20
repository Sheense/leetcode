package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Classname 两棵二叉搜索树中的所有元素
 * @Date 2022/5/1 12:01 上午
 * @Created by sheen
 * @Description TODO
 */
public class 两棵二叉搜索树中的所有元素 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Process process1 = new Process(root1);
        Process process2 = new Process(root2);
        List<Integer> res = new ArrayList<>();
        while (!process1.isEmpty() || !process2.isEmpty()) {
            if(process1.isEmpty()) {
                res.add(process2.peek());
                process2.next();
                continue;
            }
            if(process2.isEmpty()) {
                res.add(process1.peek());
                process1.next();
                continue;
            }

            if(process1.peek() >= process2.peek()) {
                res.add(process2.peek());
                process2.next();
            }else {
                res.add(process1.peek());
                process1.next();
            }

        }

        return res;
    }

    public static class Process{
        private Stack<TreeNode> stack = new Stack<>();
        private TreeNode root;
        public Process(TreeNode root) {
            this.root = root;

            if(root != null) {
                stack.push(root);
                update();
            }

        }

        public int peek() {

            return stack.peek().val;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public void next() {
           TreeNode node = stack.pop();
           if(node.right != null) {
               stack.push(node.right);
               update();
           }
        }

        private void update() {
            while (stack.peek().left!=null) {
                stack.push(stack.peek().left);
            }
        }
    }


}
