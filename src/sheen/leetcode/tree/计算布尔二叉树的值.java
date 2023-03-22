package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 计算布尔二叉树的值
 * @Date 2023/2/6 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 计算布尔二叉树的值 {
    public boolean evaluateTree(TreeNode root) {
        return judge(root);
    }

    public boolean judge(TreeNode root) {
        if(root.val == 0 || root.val == 1) {
            return root.val == 1;
        }

        if(root.val == 2) {
            return judge(root.left) || judge(root.right);
        }else {
            return judge(root.left) && judge(root.right);
        }
    }
}
