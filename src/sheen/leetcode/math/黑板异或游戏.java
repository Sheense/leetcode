package sheen.leetcode.math;

public class 黑板异或游戏 {
    public boolean xorGame(int[] nums) {
        int a = nums[0];
        for(int i = 1; i<nums.length;i++) {
            a ^= nums[i];
        }
        if(a == 0) return true;
        if(nums.length % 2 == 0) {
            return true;
        }
        return false;
    }
}
