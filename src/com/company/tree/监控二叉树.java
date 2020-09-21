package com.company.tree;

import com.company.common.TreeNode;
//状态 aa：\textit{root}root 必须放置摄像头的情况下，覆盖整棵树需要的摄像头数目。
//状态 bb：覆盖整棵树需要的摄像头数目，无论 \textit{root}root 是否放置摄像头。
//状态 cc：覆盖两棵子树需要的摄像头数目，无论节点 \textit{root}root 本身是否被监控到。
//a = lc+rc+1
//b = min(a,min(la+rb,ra+lb))
//c=min(a, lb+rb)

public class 监控二叉树 {
    public int minCameraCover(TreeNode root) {
        return find(root)[1];
    }

    public int[] find(TreeNode root) {
        if(root == null) {
            return new int[]{Integer.MAX_VALUE, 0 ,0};
        }
        int[] arr1 = find(root.left);
        int[] arr2 = find(root.right);
        int a = arr1[2]+arr2[2]+1;
        int b = Math.min(a,Math.min(arr1[0]+arr2[1], arr1[1]+arr2[0]));
        int c = Math.min(a, arr1[1]+arr2[1]);
        return new int[]{a,b,c};
    }
}
