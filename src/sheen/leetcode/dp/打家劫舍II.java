package sheen.leetcode.dp;

public class 打家劫舍II {

    public static void main(String[] args) {
        打家劫舍II s = new 打家劫舍II();
        System.out.println(s.rob(new int[]{1,2,1,1}));
    }
    //最后一间和第一间是不能同时被偷，确定了两个范围，偷第一间的前提下，在0~nums.length-2的dp；不偷第一间的前提下，在0~nums.length-1的dp
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp1 = new int[nums.length-1];
        dp1[0] = nums[0];
        for(int i=1;i<dp1.length;i++) {
            dp1[i] = i == 1 ? Math.max(nums[i], dp1[i-1]) : Math.max(nums[i] + dp1[i-2], dp1[i-1]);
        }

        int [] dp2 = new int[nums.length];
        for(int i=1;i<dp2.length;i++) {
            dp2[i] = i == 1 ? Math.max(nums[i], dp2[i-1]) : Math.max(nums[i] + dp2[i-2], dp2[i-1]);
        }

        return Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);
    }
}
