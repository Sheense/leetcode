package com.company.tree;

import com.company.common.TreeNode;

import java.util.*;

/**
 * @Classname 在每个树行中找最大值
 * @Date 2022/6/24 12:29 上午
 * @Created by sheen
 * @Description TODO
 */
public class 在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return Arrays.asList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            while (size -- != 0) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
