package sheen.leetcode.dp;

public class 整数拆分 {
    public static void main(String[] args) {
        整数拆分 s = new 整数拆分();
        System.out.println(s.integerBreak(10));
    }
    public int integerBreak(int n) {
        int [] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            int max = 1;
            for(int j=1;j<i;j++) {
                int num = Math.max(dp[j]*dp[i-j], dp[j]*(i-j));
                if(num>max) {
                    max = num;
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
