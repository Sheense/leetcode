package sheen.leetcode.dp;

import java.util.Stack;

public class 最佳观光组合 {
    public int maxScoreSightseeingPair(int[] A) {
        int[] dp = new int[A.length];
        for(int i=0;i<A.length;i++) {
            if(i==0) dp[0] = A[i] +i;
            else {
                dp[i] = Math.max(dp[i-1],A[i]+i);
            }
        }
        int res = 0;
        for(int i=1;i<A.length;i++) {
            res = Math.max(res, A[i]-i+dp[i-1]);
        }
        return res;
    }
}
