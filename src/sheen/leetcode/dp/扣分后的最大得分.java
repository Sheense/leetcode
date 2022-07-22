package sheen.leetcode.dp;

/**
 * @Classname 扣分后的最大得分
 * @Date 2021/7/19 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 扣分后的最大得分 {
    public static void main(String[] args) {
        扣分后的最大得分 s = new 扣分后的最大得分();
        System.out.println(s.maxPoints(new int[][]{{1},{2},{4}}));
    }
    public long maxPoints(int[][] points) {
        long[][] dp = new long[points.length][points[0].length];
        long[] maxLeft = new long[points[0].length];
        long[] maxRight = new long[points[0].length];
        for(int i = 0; i < points.length; i++) {
            if(i == 0) {
                for(int j = 0; j < points[i].length; j++) {
                    dp[i][j] = points[i][j];
                }
            }else {
                for(int j = 0; j < points[i].length; j++) {
                    dp[i][j] = points[i][j] + Math.max(maxLeft[j] - j, maxRight[j]+j);
                }
            }
            for(int j = 0; j < points[i].length; j++) {
                if(j == 0) {
                    maxLeft[j] = dp[i][j] + j;
                    maxRight[points[i].length - j - 1] = dp[i][points[i].length - j - 1] - (points[i].length - j - 1);
                }else {
                    maxLeft[j] = Math.max(dp[i][j] + j, maxLeft[j-1]);
                    maxRight[points[i].length - j - 1] = Math.max(maxRight[points[i].length - j], dp[i][points[i].length - j - 1] - (points[i].length - j - 1));
                }
            }
        }
        long res = 0;
        for(int i = 0; i < points[0].length; i++) {
            res = Math.max(dp[points.length-1][i], res);
        }
        return res;
    }
}
