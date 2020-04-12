package com.company.tree;

import com.company.common.TreeNode;

public class 从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        return build(0, preorder.length-1, preorder, 0, inorder.length-1,inorder);
    }

    public TreeNode build (int start1, int end1, int[] preorder , int start2,int end2, int[]inorder) {
        if(start1>end1) return null;
        TreeNode root = new TreeNode(preorder[start1]);
        int mid = 0;
        for(int i=start2;i<=end2;i++){
            if(inorder[i]==preorder[start1]) {
                mid = i;
            }
        }
        root.left= build(start1+1, mid-start2+start1, preorder,start2,mid-1,inorder);
        root.right = build(mid-start2+start1+1, end1, preorder, mid+1,end2,inorder);
        return root;
    }
}
