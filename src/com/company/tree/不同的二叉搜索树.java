package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树 {

    public int numTrees(int n) {
        if(n==0) return 0;
        return build(0,n-1);
    }
    public int build(int start, int end) {
        if(start>=end) {
            return 1;
        }
        int res = 0;
        for(int i=start;i<=end;i++) {
            int left = build(start, i-1);
            int right = build(i+1,end);
            res += left*right;
        }
        return res;
    }
}
