package sheen.leetcode.dp;

/**
 * @Classname 粉刷房子
 * @Date 2022/6/25 12:53 上午
 * @Created by sheen
 * @Description TODO
 */
public class 粉刷房子 {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        for(int i = 0; i < costs.length; i++) {
            if(i == 0) {
                dp[i][0] = costs[i][0];
                dp[i][1] = costs[i][1];
                dp[i][2] = costs[i][2];
            }else {
                for(int j = 0; j < 3; j++) {
                    if(j == 0) {
                        dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
                    }else if(j == 1) {
                        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
                    }else {
                        dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
                    }
                }
            }
        }

        return Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
    }
}
