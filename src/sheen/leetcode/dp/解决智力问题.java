package sheen.leetcode.dp;

/**
 * @Classname 解决智力问题
 * @Date 2022/1/16 11:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 解决智力问题 {
    public static void main(String[] args) {
        解决智力问题 s = new 解决智力问题();
        System.out.println(s.mostPoints(new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5}}));
    }
    public long mostPoints(int[][] questions) {
        long[][] dp = new long[questions.length][2];
        for(int i = questions.length - 1; i >= 0; i--) {
            if(i + 1 < questions.length) {
                dp[i][0] = Math.max(dp[i+1][0], dp[i+1][1]);
            }

            if(i + questions[i][1] + 1 < questions.length) {
                dp[i][1] = Math.max(dp[i + questions[i][1] + 1][1], dp[i + questions[i][1] + 1][0]) + questions[i][0];
            }else {
                dp[i][1] = questions[i][0];
            }
        }

        return Math.max(dp[0][1], dp[0][0]);
    }
}
