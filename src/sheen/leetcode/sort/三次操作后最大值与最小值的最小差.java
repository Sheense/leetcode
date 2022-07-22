package sheen.leetcode.sort;

import java.util.Arrays;

public class 三次操作后最大值与最小值的最小差 {
    public static void main(String[] args) {
        三次操作后最大值与最小值的最小差 s = new 三次操作后最大值与最小值的最小差();
        System.out.println(s.minDifference(new int[]{1,5,6,14,15}));
    }
    public int minDifference(int[] nums) {
        if(nums.length<=4) return 0;
        Arrays.sort(nums);
        int v1 = nums[nums.length-4] - nums[0];
        int v2 = nums[nums.length-1] - nums[3];
        int v3 = nums[nums.length-2] - nums[2];
        int v4 = nums[nums.length-3] - nums[1];
        return Math.min(Math.min(v1,v2), Math.min(v3,v4));
    }
}
