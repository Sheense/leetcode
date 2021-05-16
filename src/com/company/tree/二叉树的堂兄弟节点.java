package com.company.tree;

import com.company.common.TreeNode;

public class 二叉树的堂兄弟节点 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x || root.val == y) return false;
        int[] a = find(root, x, 0);
        int[] b = find(root, y, 0);
        if(a != null && b != null) {
            if(a[1] == b[1] && a[0] != b[0]) {
                return true;
            }
        }
        return false;
    }

    public int[] find(TreeNode root, int x, int c) {
        if(root == null) return null;
        if(root.left != null) {
            if(root.left.val == x) {
                return new int[]{root.val, c+1};
            }else {
                int[] res = find(root.left, x, c+1);
                if(res != null) return res;
            }
        }
        if(root.right != null) {
            if(root.right.val == x) {
                return new int[]{root.val, c+1};
            }else {
                int[] res = find(root.right, x, c+1);
                if(res != null) return res;
            }
        }
        return null;
    }
}
