package com.company.tree;

import com.company.common.TreeNode;

public class 相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        else if(p==null || q==null) return false;
        else {
            if(p.val==q.val) {
                if(!isSameTree(p.left,q.left)) return false;
                return isSameTree(p.right,q.right);
            }else return false;
        }
    }
}
