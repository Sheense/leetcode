package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树II {


    public static void main(String[] args) {

    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return build(0,n-1);
    }

    public List<TreeNode> build(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start==end) {
            res.add(new TreeNode(start+1));
            return res;
        }
        if(start>end) return res;
        for(int i=start;i<=end;i++) {
            List<TreeNode> left = build(start, i-1);
            List<TreeNode> right = build(i+1,end);
            if(left.size()==0) {
                for(int j = 0;j<right.size();j++) {
                    TreeNode node = new TreeNode(i+1);
                    node.right = right.get(j);
                    res.add(node);
                }
                continue;
            }
            if(right.size()==0) {
                for(int j = 0;j<left.size();j++) {
                    TreeNode node = new TreeNode(i+1);
                    node.left = left.get(j);
                    res.add(node);
                }
                continue;
            }
            for(int j=0;j<left.size();j++){
                for(int z=0;z<right.size();z++) {
                    TreeNode node = new TreeNode(i+1);
                    node.left = left.get(j);
                    node.right = right.get(z);
                    res.add(node);
                }
            }
        }
        return res;
    }
}
