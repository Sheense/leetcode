package sheen.leetcode.dfs;


import java.util.Arrays;

/**
 * @Classname 石子游戏II
 * @Date 2023/2/22 12:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 石子游戏II {
    public static void main(String[] args) {
        石子游戏II s = new 石子游戏II();
        System.out.println(s.stoneGameII(new int[]{2,7,9,4,4}));

        System.out.println(s.stoneGameII1(new int[]{2,7,9,4,4}));
    }
    public int stoneGameII1(int[] piles) {
        for(int i = piles.length - 2; i >= 0; i--) {
            piles[i] += piles[i + 1];
        }
        int[][] dp = new int[piles.length][piles.length + 1];
        for(int i = piles.length - 1; i >= 0; i--) {
            for(int M = 1; M < dp[i].length; M++) {
                if(2 * M + i >= piles.length) {
                    dp[i][M] = piles[i];
                    continue;
                }
                for(int z = 1; z <= 2 * M; z++) {
                    dp[i][M] = Math.max(dp[i][M], piles[i] - dp[i + z][Math.max(z, M)]);
                }
            }
        }
        return dp[0][1];
    }

    private int[][] dp;
    public int stoneGameII(int[] piles) {
        dp = new int[piles.length][2 * piles.length];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[] afterArr = piles;
        for(int i = piles.length - 2; i >= 0; i--) {
            afterArr[i] += afterArr[i + 1];
        }

        return getMax(0, 1, afterArr);
    }


    public int getMax(int i, int M, int[] afterArr) {
        if(i + 2 * M >= afterArr.length) {
            return afterArr[i];
        }
        if(dp[i][M] != -1) {
            return dp[i][M];
        }

        int min = Integer.MAX_VALUE;
        for(int j = 1; j <= 2 * M; j++) {
            min = Math.min(min, getMax(i + j, Math.max(j, M), afterArr));
        }

        dp[i][M] = afterArr[i] - min;
        return dp[i][M];
    }
}
