package sheen.leetcode.dp;

/**
 * @Classname 出界的路径数
 * @Date 2021/8/15 12:53 上午
 * @Created by sheen
 * @Description TODO
 */
public class 出界的路径数 {
    public static void main(String[] args) {
        出界的路径数 s = new 出界的路径数();
        s.findPaths(2,2, 1,0, 0);
    }
    int mod = (int)Math.pow(10, 9) + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove == 0) return 0;
        int dp[][][] = new int[maxMove][m][n];
        long res = init(dp, startRow, startColumn);
        for(int i = 0; i < maxMove - 1; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < n; k++) {
                    if(i != 0) {
                        dp[i][j][k] = merge(dp, i, j, k);
                    }
                    long item = ((long)dp[i][j][k] * count(m, n, j, k)) % mod;
                    res = (res + item) % mod;
                }
            }
        }
        return (int)res;
    }
    public int merge(int[][][] dp, int i, int j, int k) {
        long res = 0;
        if(j - 1 >= 0) {
            res += dp[i-1][j-1][k];
            res %= mod;
        }
        if(j + 1 < dp[0].length) {
            res += dp[i-1][j+1][k];
            res %= mod;
        }
        if(k - 1 >= 0) {
            res += dp[i-1][j][k-1];
            res %= mod;
        }
        if(k + 1 < dp[0][0].length) {
            res += dp[i-1][j][k+1];
            res %= mod;
        }
        return (int)res;
    }

    public int init(int[][][] dp, int startRow, int startColumn) {
        int res = 0;
        if(startRow - 1 >= 0) {
            dp[0][startRow - 1][startColumn] = 1;
        }else {
            res ++;
        }
        if(startRow + 1 < dp[0].length) {
            dp[0][startRow + 1][startColumn] = 1;
        }else {
            res++;
        }
        if(startColumn - 1 >= 0) {
            dp[0][startRow][startColumn - 1] = 1;
        }else {
            res++;
        }
        if(startColumn + 1 < dp[0][0].length) {
            dp[0][startRow][startColumn + 1] = 1;
        }else {
            res++;
        }
        return res;
    }

    public int count(int m, int n, int j, int k) {
        int count = 0;
        if(j - 1 < 0) count++;
        if(j + 1 >= m) count++;
        if(k - 1 < 0) count++;
        if(k + 1 >= n) count++;
        return count;
    }
}
