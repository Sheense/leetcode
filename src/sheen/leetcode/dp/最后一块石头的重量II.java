package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

public class 最后一块石头的重量II {
    public static void main(String[] args) {
        最后一块石头的重量II s = new 最后一块石头的重量II();
        System.out.println(s.lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i =0 ;i<stones.length;i++) sum += stones[i];
        boolean[][] dp = new boolean[stones.length+1][sum/2+1];
        dp[0][0] = true;
        for (int i = 0; i<stones.length; i++) {
            for(int j = 0; j <= sum/2; j++) {
                if (j < stones[i]) {
                    dp[i+1][j] = dp[i][j];
                }else {
                    dp[i+1][j] = dp[i][j-stones[i]] || dp[i][j];
                }
            }
        }
        ArrayUtils.print2(dp);
        for (int i = sum/2;;i--) {
            if(dp[stones.length][i]) {
                return sum - 2 * i;
            }
        }
    }



}
