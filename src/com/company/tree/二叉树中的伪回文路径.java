package com.company.tree;

import com.company.common.TreeNode;

public class 二叉树中的伪回文路径 {

    public static void main(String[] args) {
        二叉树中的伪回文路径 s = new 二叉树中的伪回文路径();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(s.pseudoPalindromicPaths(root));
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int [] arr = new int[9];
        return find(arr, root);
    }

    public int find(int[] arr,TreeNode root) {
        if(root.left==null&&root.right==null) {
            arr[root.val-1]++;
            boolean flag = false;
            for(int i=0;i<arr.length;i++) {
                if(arr[i]%2!=0) {
                    if(!flag) flag= true;
                    else {
                        arr[root.val-1]--;
                        return 0;
                    }

                }
            }
            arr[root.val-1]--;
            return 1;
        }
        arr[root.val-1]++;

        int res = 0;
        if(root.left!=null) {
            res = find(arr, root.left);
        }
        if(root.right!=null) {
            res +=find(arr, root.right);
        }
        arr[root.val-1]--;
        return res;
    }
}
