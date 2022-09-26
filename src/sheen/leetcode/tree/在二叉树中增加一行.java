package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 在二叉树中增加一行
 * @Date 2022/8/5 12:25 上午
 * @Created by sheen
 * @Description TODO
 */
public class 在二叉树中增加一行 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode res = new TreeNode(val);
            res.left = res;
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nowDep = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size--!=0) {
                TreeNode node = queue.poll();
                if(nowDep == depth - 1) {
                    TreeNode newLeftNode = new TreeNode(val);
                    newLeftNode.left = node.left;
                    node.left = newLeftNode;

                    TreeNode newRightNode = new TreeNode(val);
                    newRightNode.right = node.right;
                    node.right = newRightNode;
                }else {
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            nowDep ++;
            if(nowDep == depth) {
                break;
            }
        }

        return root;
    }
}
