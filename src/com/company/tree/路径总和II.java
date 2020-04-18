package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 路径总和II {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        recall(res, sum, root, new ArrayList<>());
        return res;
    }

    public void recall(List<List<Integer>> res, int sum, TreeNode root, List<Integer> now){
        int num = sum - root.val;
        List<Integer> list = new ArrayList<>(now);
        list.add(root.val);
        if(num==0&&root.right==null&&root.left==null){
            res.add(list);
        }
        if(root.left!=null) {
            recall(res, num, root.left, list);
        }
        if(root.right!=null) {
            recall(res, num, root.right, list);
        }
    }
}
