package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 二叉搜索树序列 {
    public static void main(String[] args) {
        二叉搜索树序列 s = new 二叉搜索树序列();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        System.out.println(s.BSTSequences(root));
    }
    public List<List<Integer>> BSTSequences(TreeNode root) {
        if(root == null) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> left = BSTSequences(root.left);
        List<List<Integer>> right = BSTSequences(root.right);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> l1 : left) {
            for(List<Integer> l2 : right) {
                if(l1.size() == 0 && l2.size() == 0) {
                    res.add(Arrays.asList(root.val));
                }else if(l1.size() == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(root.val);
                    item.addAll(l2);
                    res.add(item);
                }else if(l2.size() == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(root.val);
                    item.addAll(l1);
                    res.add(item);
                } else {
                    List<List<Integer>> seq = new ArrayList<>();
                    findSeq(l1, l2, seq, new ArrayList<>(), 0, 0);
                    for(List<Integer> l : seq) {
                        List<Integer> item = new ArrayList<>();
                        item.add(root.val);
                        item.addAll(l);
                        res.add(item);
                    }
                }
            }
        }

        return res;
    }


    public void findSeq(List<Integer> a, List<Integer> b, List<List<Integer>> res, List<Integer> now, int i, int j) {
        if(i == a.size()) {
            now.addAll(b.subList(j, b.size()));
            res.add(now);
            return;
        }
        if(j == b.size()) {
            now.addAll(a.subList(i, a.size()));
            res.add(now);
            return;
        }
        List<Integer> copy = new ArrayList<>(now);
        now.add(a.get(i));
        findSeq(a, b, res, now, i+1, j);
        copy.add(b.get(j));
        findSeq(a, b, res, copy, i, j+1);
    }
}
