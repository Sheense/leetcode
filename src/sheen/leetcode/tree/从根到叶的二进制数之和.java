package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

/**
 * @Classname 从根到叶的二进制数之和
 * @Date 2022/5/30 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 从根到叶的二进制数之和 {
    public static void main(String[] args) {
        从根到叶的二进制数之和 s = new 从根到叶的二进制数之和();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right= new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(s.sumRootToLeaf(root));
    }
    private static int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        recall(root, 0 );
        return res;
    }

    public void recall(TreeNode root, int now) {

        now = (now << 1) | root.val;
        if(root.left == null && root.right == null) {
            res += now;
            return;
        }
        if(root.left != null) {
            recall(root.left, now);
        }
        if(root.right != null) {
            recall(root.right, now);
        }
    }

}
