package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 使序列递增的最小交换次数
 * @Date 2022/10/10 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 使序列递增的最小交换次数 {
    public static void main(String[] args) {
        使序列递增的最小交换次数 s = new 使序列递增的最小交换次数();
        System.out.println(s.minSwap(new int[]{2,1,6,9,10,13,13,16,19,26,23,24,25,27,32,31,35,36,37,39},
                new int[]{0,5,8,8,10,12,14,15,22,22,28,29,30,31,30,33,33,36,37,38}));
    }
    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];
        dp[0][1] = 1;
        for(int i = 1; i < nums1.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            if(nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i][0]);
                dp[i][1] = Math.min(dp[i - 1][1] + 1, dp[i][1]);
            }

            if(nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }
        ArrayUtils.print2(dp);
        return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
    }
}
