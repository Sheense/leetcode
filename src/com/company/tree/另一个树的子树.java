package com.company.tree;

import com.company.common.TreeNode;

public class 另一个树的子树 {

    public static void main(String[] args) {
        另一个树的子树 s = new 另一个树的子树();
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);
/*
        root1.left.left.left = new TreeNode(0);
*/
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println(s.isSubtree(root1,root2));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return find(s,t);
    }

    public boolean find(TreeNode s, TreeNode t) {
        if(s==null) return false;
        if(s.val == t.val) {
            boolean res = check(s,t);
            if(res) return res;
        }
        boolean a = find(s.left,t);
        if(a) return a;
        boolean b = find(s.right,t);
        if(b) return b;
        return false;
    }

    public boolean check(TreeNode s, TreeNode t) {
        if((s==null&&t!=null)||(s!=null&&t==null)) return false;
        if((s==null&&t==null)||s.val==t.val) {
            if(s==null) return true;
            return check(s.left,t.left)&&check(s.right,t.right);
        }else return false;
    }
}
