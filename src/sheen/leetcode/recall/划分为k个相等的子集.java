package sheen.leetcode.recall;

import java.util.Arrays;

/**
 * @Classname 划分为k个相等的子集
 * @Date 2022/9/20 12:29 上午
 * @Created by sheen
 * @Description TODO
 */
public class 划分为k个相等的子集 {
    public static void main(String[] args) {
        划分为k个相等的子集 s = new 划分为k个相等的子集();
        System.out.println(s.canPartitionKSubsets(new int[]{1,2,3,4}, 3));
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int all = 0;
        for(int i = 0; i < nums.length; i++) {
            all += nums[i];
        }
        if(all % k != 0) return false;
        Arrays.sort(nums);
        int mod = all / k;
        if(nums[nums.length - 1] > mod) {
            return false;
        }
        boolean dp[] = new boolean[(1 << nums.length)];
        Arrays.fill(dp, true);
        return recall(nums, 0, mod, dp, 0);
    }

    public boolean recall(int nums[], int nowAll, int mod, boolean[] dp, int state) {
        if(state == ((1 << nums.length) - 1)) {
            return true;
        }
        for(int i = 0; i < nums.length; i++) {
            int newState = state | (1 << i);
            if((state & (1 << i)) == 0 && dp[newState]) {
                if(nowAll + nums[i] == mod){
                    boolean flag = recall(nums, 0, mod, dp, newState);
                    if(flag) {
                        return true;
                    }
                    dp[newState] = false;
                }else if(nowAll + nums[i] < mod){
                    boolean flag =  recall(nums, nowAll + nums[i], mod, dp, newState);
                    if(flag) {
                        return true;
                    }
                    dp[newState] = false;
                }
            }
        }
        return false;
    }
}
