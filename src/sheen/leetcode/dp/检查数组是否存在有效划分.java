package sheen.leetcode.dp;

/**
 * @Classname 检查数组是否存在有效划分
 * @Date 2024/3/1 00:22
 * @Created by sheen
 * @Description TODO
 */
public class 检查数组是否存在有效划分 {
    public boolean validPartition(int[] nums) {
        if(nums.length < 2) {
            return false;
        }
        boolean [] dp = new boolean[nums.length];
        dp[1] = judge(0, 1, nums);

        if(nums.length >= 3) {
            dp[2] = judge(0, 2, nums);
        }

        for(int i = 3; i < nums.length; i++) {
            dp[i] = (judge(i - 2, i, nums) && dp[i - 3])
                    || (judge(i - 1, i, nums) && dp[i - 2]) ;
        }

        return dp[dp.length - 1];
    }

    public boolean judge(int start, int end, int[] nums) {
        if(end - start == 2) {
            if(nums[end] == nums[start] && nums[end] == nums[end - 1]) {
                return true;
            }
            if(nums[end] == nums[start] + 2 && nums[end] == nums[end - 1] + 1) {
                return true;
            }
        }
        if(end - start == 1) {
            if(nums[end] == nums[start]) {
                return true;
            }
        }
        return false;

    }
}
