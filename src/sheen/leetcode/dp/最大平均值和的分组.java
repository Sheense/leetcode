package sheen.leetcode.dp;

/**
 * @Classname 最大平均值和的分组
 * @Date 2022/11/28 12:27 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大平均值和的分组 {
    public static void main(String[] args) {
        最大平均值和的分组 s = new 最大平均值和的分组();
        System.out.println(s.largestSumOfAverages(new int[]{9,1,2,3,9}, 3));
    }

    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[k][nums.length];
        int[] pre = new int[nums.length];
        for(int i = 0; i < pre.length; i++) {
            if(i == 0) {
                pre[i] = nums[i];
            }else {
                pre[i] = pre[i - 1] + nums[i];
            }
        }

        for(int i = 0; i < k; i++) {
            for(int j = i; j < nums.length; j ++) {
                if(i == 0) {
                    dp[0][j] = (double) pre[j] / (j + 1);
                }else {
                    for(int z = j - 1; z >= i - 1; z--) {
                        double value = (double) (pre[j] - pre[z]) / (j - z);
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][z] + value);
                    }
                }
            }
        }

        return dp[k - 1][nums.length - 1];
    }

}
