package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 从叶结点开始的最小字符串 {


    public String smallestFromLeaf(TreeNode root) {
        List<String> res = new ArrayList<>();
        recall(root, "", res);
        Collections.sort(res);
        return res.get(0);
    }

    public void recall(TreeNode root, String now, List<String> res) {
        now = (char)(root.val+'a') + now;
        if(root.left==null&&root.right==null) res.add(now);
        else if(root.left==null) recall(root.right, now, res);
        else if(root.right==null) recall(root.left, now, res);
        else {
            recall(root.left, now, res);
            recall(root.right, now, res);
        }
    }


}
