package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 根据二叉树创建字符串
 * @Date 2022/3/19 1:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 根据二叉树创建字符串 {
    public String tree2str(TreeNode root) {
        String res = recall(root);
        return res;
    }

    public String recall(TreeNode root) {
        if(root == null) {
            return null;
        }
        String res = String.valueOf(root.val);
        String left = recall(root.left);
        if(left != null) {
            res += "(" + left  +")";
        }
        String right = recall(root.right);
        if(right != null) {
            if(left == null) {
                res += "()";
            }
            res += "(" + right + ")";
        }
        return res;
    }
}
