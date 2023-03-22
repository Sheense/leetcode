package sheen.leetcode.dp;

/**
 * @Classname 下降路径最小和
 * @Date 2023/3/3 6:01 下午
 * @Created by sheen
 * @Description TODO
 */
public class 下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = 0; j < matrix[i].length; j++) {
                dp[i][j] = matrix[i][j];
                if(i < matrix.length - 1) {
                    int min = dp[i + 1][j];
                    if(j - 1 >= 0) {
                        min = Math.min(min, dp[i + 1][j - 1]);
                    }

                    if(j + 1 < matrix[i].length) {
                        min = Math.min(min, dp[i + 1][j + 1]);
                    }
                    dp[i][j] += min;
                }
            }
        }

        int res = dp[0][0];
        for(int i = 1; i < dp[0].length; i++) {
            res = Math.min(dp[0][i], res);
        }
        return res;
    }
}
