package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 层数最深叶子节点的和
 * @Date 2022/8/17 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 层数最深叶子节点的和 {
    public int deepestLeavesSum(TreeNode root) {
        return recall(root, 1)[1];
    }

    public int[] recall(TreeNode root, int floor) {
        if(root.left == null && root.right == null) {
            return new int[]{floor, root.val};
        }

        if(root.left == null) {
            return recall(root.right, floor + 1);
        }

        if(root.right == null) {
            return recall(root.left, floor + 1);
        }

        int[] left = recall(root.left, floor + 1);
        int[] right = recall(root.right, floor + 1);
        if(left[0] == right[0]) {
            return new int[]{left[0], left[1] + right[1]};
        }else if(left[0] > right[0]) {
            return left;
        }else {
            return right;
        }
    }
}
