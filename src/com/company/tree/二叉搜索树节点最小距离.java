package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树节点最小距离 {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recall(root, list);
        int res = Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++) {
            res = Math.min(res, list.get(i+1) - list.get(i));
        }
        return res;
    }

    public void recall(TreeNode root, List<Integer> list) {
        if(root==null) return;
        recall(root.left, list);
        list.add(root.val);
        recall(root.right, list);
    }
}
