package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 最大层内元素和
 * @Date 2022/7/31 12:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大层内元素和 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        int resInd = -1;
        int index = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int ans = 0;
            while (size-- != 0) {
                TreeNode node = queue.poll();
                ans += node.val;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(res < ans) {
                res = ans;
                resInd = index;
            }
            index++;
        }
        return resInd;
    }
}
