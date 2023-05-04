package sheen.leetcode.dp;

/**
 * @Classname 分隔数组以得到最大和
 * @Date 2023/4/19 12:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 分隔数组以得到最大和 {
    public static void main(String[] args) {
        分隔数组以得到最大和 s = new 分隔数组以得到最大和();
        System.out.println(s.maxSumAfterPartitioning(new int[]{1}, 4));
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                dp[i] = arr[i];
            }else {
                int max = arr[i];
                for(int j = 0; j < k && i - j >= 0; j++) {
                    max = Math.max(max, arr[i - j]);
                    dp[i] = Math.max(dp[i], (j + 1) * max + (i - (j + 1) < 0 ? 0 : dp[i - (j + 1)]));
                }
            }
        }
        return dp[dp.length - 1];
    }
}
