package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 判断根结点是否等于子结点之和
 * @Date 2023/8/20 00:04
 * @Created by sheen
 * @Description TODO
 */
public class 判断根结点是否等于子结点之和 {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
