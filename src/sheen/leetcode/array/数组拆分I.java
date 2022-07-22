package sheen.leetcode.array;

import java.util.Arrays;

public class 数组拆分I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=nums.length-2;i>=0;i-=2) {
            res += nums[i];
        }
        return res;
    }
}
