package sheen.leetcode.dp;

import java.util.TreeSet;

/**
 * @Classname 任意子数组和的绝对值的最大值
 * @Date 2023/8/8 00:10
 * @Created by sheen
 * @Description TODO
 */
public class 任意子数组和的绝对值的最大值 {
    public static void main(String[] args) {
        任意子数组和的绝对值的最大值 s = new 任意子数组和的绝对值的最大值();
        System.out.println(s.maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
    }
    public int maxAbsoluteSum(int[] nums) {
        if(nums.length == 1) {
            return Math.abs(nums[0]);
        }
        int res = Math.abs(nums[0]);
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            min = Math.min(min + nums[i], nums[i]);
            res = Math.max(Math.max(Math.abs(max), Math.abs(min)), res);
        }
        return res;
    }
}
