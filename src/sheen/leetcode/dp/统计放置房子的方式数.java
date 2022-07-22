package sheen.leetcode.dp;

/**
 * @Classname 统计放置房子的方式数
 * @Date 2022/6/26 10:50 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计放置房子的方式数 {
    public static void main(String[] args) {
        统计放置房子的方式数 s = new 统计放置房子的方式数();
        System.out.println(s.countHousePlacements(2));
    }
    public int countHousePlacements(int n) {
        int mod = (int)Math.pow(10, 9) + 7;
        int[][] dp = new int[n][4];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 4; j++) {
                dp[i][0] += dp[i - 1][j];
                dp[i][0] %= mod;
                if(j != 1 && j != 3) {
                    dp[i][1] += dp[i - 1][j];
                    dp[i][1] %= mod;
                }

                if(j != 2 && j != 3) {
                    dp[i][2] += dp[i - 1][j];
                    dp[i][2] %= mod;
                }

                if(j == 0) {
                    dp[i][3] = dp[i - 1][j];
                    dp[i][3] %= mod;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < 4; i++) {
            res += dp[n - 1][i];
            res %= mod;
        }

        return res;
    }
}
