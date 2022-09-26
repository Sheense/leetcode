package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 最大二叉树
 * @Date 2022/8/20 12:38 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recall(nums, 0, nums.length - 1);
    }

    public TreeNode recall(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int index = findMaxIndex(nums, left, right);
        TreeNode node = new TreeNode(nums[index]);
        node.left = recall(nums, left, index - 1);
        node.right = recall(nums, index + 1, right);
        return node;
    }

    public int findMaxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for(int i = left; i <= right; i++) {
            if(nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
