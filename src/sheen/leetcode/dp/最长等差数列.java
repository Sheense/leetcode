package sheen.leetcode.dp;

/**
 * @Classname 最长等差数列
 * @Date 2023/4/22 1:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最长等差数列 {
    public static void main(String[] args) {
        最长等差数列 s = new 最长等差数列();
        System.out.println(s.longestArithSeqLength(new int[]{9,4,7,2,10}));
    }
    public int longestArithSeqLength(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int res = 0;
        int diff = max - min;
        for(int d = -diff; d <= diff; d++) {
            int[] dp = new int[max + 1];
            for(int num : nums) {
                if(num - d >= 0 && num - d <= max) {
                    dp[num] = dp[num - d] + 1;
                }else {
                    dp[num] = 1;
                }
                res = Math.max(res, dp[num]);
            }
        }

        return res;
    }
}
