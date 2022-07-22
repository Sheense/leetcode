package sheen.leetcode.dp;

import java.util.Arrays;

public class 粉刷房子III {
    public static void main(String[] args) {
        粉刷房子III s = new 粉刷房子III();
        System.out.println(s.minCost(new int[]{3,1,2,3}, new int[][]{{1,1,1},{1,1,1},{1,1,1},{1,1,1}},
                4,3,3));
    }
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[target+1][m][n];
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[0][i], Integer.MAX_VALUE);
        }
        for(int i=1;i<=target;i++) {
            for(int j=0;j<m;j++) {
                if (houses[j] != 0) {
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
                    if(j==0) {
                        if (i == 1) {
                            dp[1][0][houses[j]-1] = 0;
                        }
                        continue;
                    }
                    int min = Integer.MAX_VALUE;
                    for(int z =0;z<n;z++) {
                        if (z != houses[j] - 1) {
                            min = Math.min(dp[i-1][j-1][z], min);
                        }
                    }
                    dp[i][j][houses[j] - 1] = Math.min(dp[i][j-1][houses[j] - 1], min);
                } else {
                     for(int z=0;z<n;z++) {
                         if(i==1 && j == 0) {
                             dp[i][j][z] = cost[j][z];
                             continue;
                         }else if(j == 0) {
                             dp[i][j][z] = Integer.MAX_VALUE;
                             continue;
                         }
                         dp[i][j][z] = Integer.MAX_VALUE;
                         int min = Integer.MAX_VALUE;
                         if(dp[i][j-1][z]!=Integer.MAX_VALUE) {
                             min = dp[i][j-1][z];
                         }
                         for(int q = 0;q<n;q++) {
                             if(q != z && dp[i-1][j-1][q] != Integer.MAX_VALUE) {
                                 min = Math.min(dp[i-1][j-1][q], min);
                             }
                         }
                         if(min != Integer.MAX_VALUE) {
                             dp[i][j][z] = min + cost[j][z];
                         }
                     }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            ans = Math.min(ans, dp[target][m-1][i]);
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}
