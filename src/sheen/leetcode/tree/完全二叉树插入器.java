package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 完全二叉树插入器
 * @Date 2022/7/25 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 完全二叉树插入器 {
    static class CBTInserter {

        private Queue<TreeNode> first = new LinkedList<>();
        private Queue<TreeNode> second = new LinkedList<>();
        private TreeNode root;
        public CBTInserter(TreeNode root) {
            this.root = root;
            buildQueue(root);
        }
        private void buildQueue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- != 0) {
                    TreeNode node = queue.poll();
                    insert(node.val);
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }

        public int insert(int val) {
            if(first.isEmpty()) {
                if(second.isEmpty()) {
                    this.root = new TreeNode(val);
                    first.offer(this.root);
                    return -1;
                }
                first = second;
                second = new LinkedList<>();
            }
            TreeNode node = first.peek();
            TreeNode newNode = new TreeNode(val);
            if(node.left == null) {
                node.left = newNode;
            }else {
                node.right = newNode;
                first.poll();
            }
            second.offer(newNode);
            return node.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
