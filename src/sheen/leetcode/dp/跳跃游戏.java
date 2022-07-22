package sheen.leetcode.dp;

public class 跳跃游戏 {

    public static void main(String[] args) {
        跳跃游戏 s = new 跳跃游戏();
        System.out.println(s.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        boolean[] dp = new boolean[nums.length];
        for(int i=nums.length-1;i>=0;i--) {
            if(i+nums[i]>=nums.length-1) {
                dp[i] = true;
                continue;
            }
            for(int j=i+1;j<=nums[i]+i&&j<nums.length;j++) {
                if(dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
