package com.company.tree;

import com.company.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 找树左下角的值
 * @Date 2022/6/22 12:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = queue.peek().val;
            while (size -- != 0) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }

        return res;
    }
}
