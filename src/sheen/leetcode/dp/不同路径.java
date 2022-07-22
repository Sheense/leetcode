package sheen.leetcode.dp;

public class 不同路径 {
    public static void main(String[] args) {
        不同路径 s = new 不同路径();
        System.out.println(s.uniquePaths(100,100));
    }
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
