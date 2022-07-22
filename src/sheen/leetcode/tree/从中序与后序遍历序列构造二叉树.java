package sheen.leetcode.tree;

import sheen.leetcode.common.TreeNode;

public class 从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        return build(0,postorder.length-1,postorder,0,inorder.length-1,inorder);
    }

    public TreeNode build(int start1, int end1, int[] postorder , int start2,int end2, int[]inorder){
        if(end1<start1) return null;
        TreeNode root = new TreeNode(postorder[end1]);
        int mid = 0;
        for(int i=start2;i<=end2;i++) {
            if(inorder[i]==postorder[end1]) {
                mid = i;
                break;
            }
        }
        root.left = build(start1, mid-start2+start1-1,postorder, start2, mid-1,inorder);
        root.right = build(mid-start2+start1, end1-1,postorder, mid+1,end2,inorder) ;
        return root;
    }
}
