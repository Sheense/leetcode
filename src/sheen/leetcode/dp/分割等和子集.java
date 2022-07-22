package sheen.leetcode.dp;

public class 分割等和子集 {
    public static void main(String[] args) {
        分割等和子集 s = new 分割等和子集();
        System.out.println(s.canPartition(new int[]{2,2,3,5}));
    }
    public boolean canPartition(int[] nums) {
        if(nums.length<2)return false;
        int sum = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        if(sum%2==1) return false;
        int avg = sum/2;
        if(avg<max) return false;
        if(avg==max) return true;
        boolean[][] dp = new boolean[nums.length][avg+1];
        for(int i=0;i<dp.length;i++) {
            dp[i][0] = true;
            for(int j=0;j<=avg;j++) {
                if(i==0) {
                    if(nums[0] == j) {
                        dp[0][j] = true;
                    }
                }else {
                    if(nums[i]>j) {
                        dp[i][j] = dp[i-1][j];
                    }else {
                        dp[i][j] = dp[i-1][j-nums[i]]||dp[i-1][j];
                    }
                }
            }
        }
        return dp[nums.length-1][avg];
    }
}
