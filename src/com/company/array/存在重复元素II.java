package com.company.array;

public class 存在重复元素II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length&&j<=i+k;j++) {
                if(nums[i]==nums[j]) return true;
            }
        }
        return false;
    }
}
