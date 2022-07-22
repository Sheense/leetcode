package sheen.leetcode.dp;

/**
 * @Classname 不含连续1的非负整数
 * @Date 2021/9/11 12:33 下午
 * @Created by sheen
 * @Description TODO
 */
public class 不含连续1的非负整数 {
    public int findIntegers(int n) {
        if(n == 0) return 1;
        int N = 35;
        int [][] dp = new int[N][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for(int i = 1; i < dp.length; i++) {
            dp[i+1][0] = dp[i][0] + dp[i][1];
            dp[i+1][1] = dp[i][0];
        }
        int len = getLen(n);
        int ans = 0, prev = 0;
        for (int i = len; i >= 0; i--) {
            // 当前位是 0 还是 1
            int cur = ((n >> i) & 1);
            // 如果当前位是 1，那么填 0 的话，后面随便填都符合，将方案数累加
            if (cur == 1) ans += dp[i + 1][0];
            // 出现连续位为 1，方案数被计算完了
            if (prev == 1 && cur == 1) break;
            prev = cur;
            if (i == 0) ans++;
        }
        return ans;

    }

    public int getLen(int n) {
        for(int i = 31; i >= 0; i--) {
            if(((n >> i) & 1) == 1) {
                return i;
            }
        }
        return 0;
    }
}
