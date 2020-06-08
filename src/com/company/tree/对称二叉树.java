package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 对称二叉树 {


    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        List<TreeNode> list = new ArrayList<>();
        list.add(root.left);
        list.add(root.right);
        boolean flag = true;
        while(flag) {
            for(int i=0;i<list.size()/2;i++) {
                if(list.get(i)==null&&list.get(list.size()-i-1)==null) {
                    continue;
                }else if(list.get(i)!=null&&list.get(list.size()-i-1)!=null&&list.get(i).val == list.get(list.size()-i-1).val){
                    continue;
                }
                return false;
            }
            List<TreeNode> newList = new ArrayList<>(list.size()*2);
            flag = false;
            for(int i=0;i<list.size();i++) {
                if(list.get(i)==null) {
                    newList.add(null);
                    newList.add(null);
                }else {
                    if(list.get(i).left!=null||list.get(i).right!=null) {
                        flag = true;
                    }
                    newList.add(list.get(i).left);
                    newList.add(list.get(i).right);
                }
            }
            list = newList;
        }
        return true;
    }
}
