package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname 反转二叉树的奇数层
 * @Date 2022/9/18 11:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 反转二叉树的奇数层 {
    public static void main(String[] args) {
        反转二叉树的奇数层 s = new 反转二叉树的奇数层();
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(13);
        root.right = new TreeNode(11);
        System.out.println(s.reverseOddLevels(root));
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            if(count % 2 == 1) {
                while (size -- != 0) {
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                }
            }else {
                List<TreeNode> list = new LinkedList<>();
                while (size -- != 0) {
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        list.add(node.left);
                    }
                    if(node.right != null) {
                        list.add(node.right);
                    }
                }

                for(int i = 0; i < list.size() / 2; i++) {
                    int a = list.get(i).val;
                    list.get(i).val = list.get(list.size() - 1 - i).val;
                    list.get(list.size() - 1 - i).val = a;
                }

                queue.addAll(list);
            }
            count++;
        }

        return root;
    }
}
