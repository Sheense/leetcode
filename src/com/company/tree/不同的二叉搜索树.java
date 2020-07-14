package com.company.tree;

import com.company.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树 {

    public static void main(String[] args) {
        不同的二叉搜索树 s = new 不同的二叉搜索树();
        System.out.println(s.numTrees(3));
    }

    public int numTrees(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<n+1;i++) {
            int v = i-1;
            for(int j=0;j<=v;j++) {
                dp[i] += dp[j] * dp[v-j];
            }
        }
        return dp[n];
    }
}
