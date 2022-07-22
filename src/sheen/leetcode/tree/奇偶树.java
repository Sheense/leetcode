package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 奇偶树
 * @Date 2021/12/25 10:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 奇偶树 {
    public static void main(String[] args) {
        奇偶树 s  = new 奇偶树();
        TreeNode root = new TreeNode(13);
        root.left = new TreeNode(34);
        root.right = new TreeNode(32);
        root.left.left = new TreeNode(23);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(27);
        root.right.right = new TreeNode(29);


        root.left.left.left = new TreeNode(44);
        root.left.left.right = new TreeNode(40);
        root.left.right.left = new TreeNode(36);
        root.left.right.right = new TreeNode(34);

        root.right.left.left = new TreeNode(30);
        root.right.left.right = new TreeNode(30);
        root.right.right.left = new TreeNode(28);
        root.right.right.right = new TreeNode(26);

        System.out.println(s.isEvenOddTree(root));
    }
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int pre = -1;
            while (size--!=0) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                if(index % 2 == 0 && node.val % 2 == 0) {
                    return false;
                }
                if(index % 2 == 1 && node.val % 2 == 1) {
                    return false;
                }
                if(pre == -1) {
                    pre = node.val;
                }else {
                    if(index % 2 == 0 && pre >= node.val) {
                        return false;
                    }
                    if(index % 2 == 1 && pre <= node.val) {
                        return false;
                    }
                    pre = node.val;
                }
            }
            index++;
        }
        return true;
    }
}
