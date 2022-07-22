package sheen.leetcode.bitOperation;

public class 只出现一次的数字 {

    public int singleNumber(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
