package com.company.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长的斐波那契子序列的长度 {

    public static void main(String[] args) {
        最长的斐波那契子序列的长度 s = new 最长的斐波那契子序列的长度();
        System.out.println(s.lenLongestFibSubseq(new int[]{1,3,5}));
    }

    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++) {
            map.put(A[i],i);
        }
        int [][] dp = new int[A.length][A.length];
        int res = 0;
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<i;j++) {
                int diff = A[i]- A[j];
                if(diff<A[j]&&map.containsKey(diff)) {
                    int k = map.get(diff);
                    if(dp[j][k]==0) dp[j][k]=2;
                    dp[i][j] = dp[j][k]+1;
                    if(dp[i][j]>res) res = dp[i][j];
                }
            }
        }
        return res;
    }
}
