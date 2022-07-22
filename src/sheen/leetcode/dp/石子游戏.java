package sheen.leetcode.dp;

public class 石子游戏 {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            for(int j = 0; i < piles.length - i; j++) {
                if(i == 0) {
                    dp[j][j] = piles[j];
                }else {
                    dp[j][i+j] = Math.max(piles[j] - dp[j+1][j+i], piles[i+j] - dp[j][i+j-1]);
                }
            }
        }
        return dp[0][piles.length-1] > 0;
    }
}
