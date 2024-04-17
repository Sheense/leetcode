package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 最大化网格幸福感
 * @Date 2023/6/24 11:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大化网格幸福感 {

    private int n;
    private int m;
    private static final int T = 243, N = 5, M = 6;
    private int tot;
    private int[][] maskBits;
    private int[] ivCount;
    private int[] evCount;
    private int[] innerScore;
    private int[][] interScore;
    private int[][][][] d;

    private static int[][] score = {
            {0, 0, 0},
            {0, -60, -10},
            {0, -10, 40}
    };

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        this.n = n;
        this.m = m;
        this.tot = (int) Math.pow(3, n);
        this.maskBits = new int[T][N];
        this.ivCount = new int[T];
        this.evCount = new int[T];
        this.innerScore = new int[T];
        this.interScore = new int[T][T];
        this.d = new int[N][T][M + 1][M + 1];
        init();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < T; j++) {
                for (int k = 0; k <= M; k++) {
                    Arrays.fill(d[i][j][k], -1);
                }
            }
        }


        return dfs(0, 0, introvertsCount, extrovertsCount);
    }

    public int dfs(int row, int premask, int iv, int ev) {
        if(row == m || (iv == 0 && ev == 0)) {
            return 0;
        }

        if(d[row][premask][iv][ev] != -1) {
            return d[row][premask][iv][ev];
        }

        int res = 0;
        for(int mask = 0; mask < tot;  mask++) {
            if(ivCount[mask] > iv || evCount[mask] > ev) {
                continue;
            }

            res = Math.max(res, dfs(row + 1, mask, iv - ivCount[mask], ev - evCount[mask])
                    + interScore[premask][mask] + innerScore[mask]);
        }
        d[row][premask][iv][ev] = res;
        return res;
    }

    public void init() {
        for(int mask = 0; mask < tot; mask++) {
            int maskTmp = mask;
            for(int i = 0; i < n; i++) {
                int x = maskTmp % 3;
                maskBits[mask][i] = x;
                maskTmp /= 3;
                if(x == 1) {
                    ivCount[mask]++;
                    innerScore[mask] += 120;
                }else if(x == 2) {
                    evCount[mask]++;
                    innerScore[mask] += 40;
                }
                if(i > 0) {
                    innerScore[mask] += score[x][maskBits[mask][i - 1]];
                }
            }
        }
        for(int i = 0; i < tot; i++) {
            for(int j = 0; j < tot; j++) {
                interScore[i][j] = 0;
                for(int k = 0; k < n; k++) {
                    interScore[i][j] += score[maskBits[i][k]][maskBits[j][k]];
                }
            }
        }
    }
}
