package com.company.tree;

import com.company.common.TreeNode;

import java.util.Map;

/**
 * @Classname 二叉树中第二小的节点
 * @Date 2021/7/27 1:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二叉树中第二小的节点 {
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        if(root.left == null && root.right == null) {
            return -1;
        }
        if(root.left.val == root.right.val) {
            int val1 = recall(root.left);
            int val2 = recall(root.right);
            if(val1 == -1 && val2 == -1) {
                return -1;
            }else if(val1 == -1) {
                return val2;
            }else if(val2 == -1) {
                return val1;
            }else {
                return Math.min(val1, val2);
            }
        }else if(root.left.val == root.val) {
            int val = recall(root.left);
            if(val == -1) {
                return root.right.val;
            }else  {
                return Math.min(root.right.val, val);
            }
        }else {
            int val = recall(root.right);
            if(val == -1) {
                return root.left.val;
            }else {
                return Math.min(root.left.val, val);
            }
        }

    }

    public int recall(TreeNode root) {
        if(root.left == null) {
            return -1;
        }
        if(root.left.val != root.right.val) {
            return Math.max(root.left.val, root.right.val);
        }else {
            int val1 = recall(root.left);
            int val2 = recall(root.right);
            if(val1 == -1 && val2 == -1) {
                return -1;
            }else if(val1 == -1) {
                return val2;
            }else if(val2 == -1) {
                return val1;
            }else {
                return Math.min(val1, val2);
            }
        }
    }
}
