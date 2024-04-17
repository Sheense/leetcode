package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 找出克隆二叉树中的相同节点
 * @Date 2024/4/3 00:03
 * @Created by sheen
 * @Description TODO
 */
public class 找出克隆二叉树中的相同节点 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return recall(cloned, target);
    }

    public TreeNode recall( TreeNode cloned, TreeNode target) {
        if(cloned == null) {
            return null;
        }

        if(cloned.val == target.val) {
            return cloned;
        }

        TreeNode res = recall(cloned.left, target);
        if(res != null) {
            return res;
        }
        res = recall(cloned.right, target);
        return res;
    }
}
