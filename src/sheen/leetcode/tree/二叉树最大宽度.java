package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 二叉树最大宽度
 * @Date 2022/8/27 10:52 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        queue.offer(root);
        index.offer(0);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0;
            int end = 0;
            for(int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                int i = index.poll();
                if(j == 0) start = i;
                if(j == size - 1) end = i;
                if(node.left != null) {
                    queue.offer(node.left);
                    index.offer(i * 2 + 1);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                    index.offer(i * 2 + 2);
                }
            }
            res = Math.max((end - start) + 1, res);
        }
        return res;
    }
}
