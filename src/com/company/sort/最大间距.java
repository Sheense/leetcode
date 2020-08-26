package com.company.sort;

import java.util.Arrays;

public class 最大间距 {
    public static void main(String[] args) {
        最大间距 s = new 最大间距();
        System.out.println(s.maximumGap(new int[]{1,3,100}));
    }
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0;i<nums.length-1;i++) {
            res = Math.max(res, nums[i+1]-nums[i]);
        }
        return res;
    }
}
