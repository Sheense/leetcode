package sheen.leetcode.array;

public class 基于排列构建数组 {
    public int[] buildArray(int[] nums) {
        int res[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
