package sheen.leetcode.dp;

/**
 * @Classname 多米诺和托米诺平铺
 * @Date 2022/11/12 9:20 下午
 * @Created by sheen
 * @Description TODO
 */
public class 多米诺和托米诺平铺 {
    public static void main(String[] args) {
        多米诺和托米诺平铺 s = new 多米诺和托米诺平铺();
        System.out.println(s.numTilings(4));
    }

    public int numTilings(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int mod = (int)Math.pow(10, 9) + 7;
        long [][] dp = new long[n + 1][4];
        dp[1][0] = 1;
        dp[1][3] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % mod;

        }
        return (int)(dp[n][3]);
    }
}
