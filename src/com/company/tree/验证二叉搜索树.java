package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return recall(root, new ArrayList<>());
    }

    public boolean recall(TreeNode root, List<Integer> list) {
        if(root.left!=null) {
            boolean a = recall(root.left, list);
            if(!a) return a;
        }
        if(list.size()==0||list.get(list.size()-1)<root.val) {
            list.add(root.val);
        }else {
            return false;
        }
        if(root.right!=null) {
            boolean a = recall(root.right, list);
            if(!a) return a;
        }
        return true;
    }

}
