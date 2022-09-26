package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 最长同值路径
 * @Date 2022/9/2 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最长同值路径 {
    public static void main(String[] args) {
        最长同值路径 s = new 最长同值路径();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(s.longestUnivaluePath(root));
    }
    public int longestUnivaluePath(TreeNode root) {
        return recall(root);
    }

    public int recall(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        if(root.left != null && root.val == root.left.val) {
            res += getMaxPoint(root.left);
        }
        if(root.right != null && root.val == root.right.val) {
            res += getMaxPoint(root.right);
        }

        return Math.max(res, Math.max(recall(root.left), recall(root.right)));
    }

    public int getMaxPoint(TreeNode root) {
        if(root == null) return 0;
        int left = 0;
        if(root.left != null && root.left.val == root.val) {
            left = getMaxPoint(root.left);
        }

        int right = 0;
        if(root.right != null && root.right.val == root.val) {
            right = getMaxPoint(root.right);
        }

        if(left == 0 && right == 0) {
            return 1;
        }else if(left >= right) {
            return left + 1;
        }else if(right > left) {
            return right + 1;
        }
        return 1;
    }
}
