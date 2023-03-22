package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 堆叠长方体的最大高度
 * @Date 2022/12/10 10:25 上午
 * @Created by sheen
 * @Description TODO
 */
public class 堆叠长方体的最大高度 {
    public int maxHeight(int[][] cuboids) {
        for(int i = 0; i < cuboids.length; i++) {
            Arrays.sort(cuboids[i]);
        }

        Arrays.sort(cuboids, (x, y) -> {
            int a = x[0] + x[1] + x[2];
            int b = y[0] + y[1] + y[2];
            return a - b;
        });

        int res = 0;

        int[] dp = new int[cuboids.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = cuboids[i][2];
            for(int j = i - 1; j >= 0; j--) {
                if(cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[j] + cuboids[i][2], dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
