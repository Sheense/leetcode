package com.company.math;

import com.company.util.ArratyUtils;

public class 两数之和 {
    public static void main(String[] args) {
        两数之和 s = new 两数之和();
        ArratyUtils.print(s.twoSum(new int[]{3,2,4},6));
    }

    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(target-nums[i]-nums[j]==0) return new int[] {i,j};
            }
        }
        return new int[0];
    }
}
