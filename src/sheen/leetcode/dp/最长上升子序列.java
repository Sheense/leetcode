package sheen.leetcode.dp;

public class 最长上升子序列 {
    public static void main(String[] args) {
        最长上升子序列 s = new 最长上升子序列();
        System.out.println(s.lengthOfLIS(new int[]{2,2}));
    }
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int dp[] = new int[nums.length];
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            int max = 0;
            for(int j=0;j<=i-1;j++) {
                if(nums[j]<nums[i]) {
                    if(max<dp[j]) max =dp[j];
                }
            }
            dp[i] = max+1;
            if(dp[i] >res) res = dp[i] ;
        }
        return res;
    }
}
