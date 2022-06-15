package com.company.tree;

import com.company.common.TreeNode;

/**
 * @Classname 删除二叉搜索树中的节点
 * @Date 2022/6/2 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        return recall(root, key);
    }

    public TreeNode recall(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(root.val == key) {
            if(root.right == null) {
                return root.left;
            }else {
                if(root.right.left == null) {
                    root.right.left = root.left;
                    return root.right;
                }else {
                    TreeNode node = findNext(root.right);
                    node.left = root.left;
                    node.right = root.right;
                    return node;
                }
            }
        }
        root.left = recall(root.left, key);
        root.right = recall(root.right, key);
        return root;
    }

    public TreeNode findNext(TreeNode root) {
        if(root.left.left == null) {
            TreeNode res = root.left;
            root.left = res.right;
            return res;
        }

        return findNext(root.left);
    }

}
