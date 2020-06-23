package com.company.array;

public class 最长连续递增序列 {
    public static void main(String[] args) {
        最长连续递增序列 s = new 最长连续递增序列();
        System.out.println(s.findLengthOfLCIS(new int[]{}));
    }

    public int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int res = 0;
        while(left<nums.length) {
            int right = left+1;
            while(right<nums.length&&nums[right]>nums[right-1]) {
                right++;
            }
            if(res<right-left) {
                res =right-left;
            }
            left = right;
        }
        return res;
    }
}
