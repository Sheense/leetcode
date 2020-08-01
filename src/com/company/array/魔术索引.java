package com.company.array;

public class 魔术索引 {
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            if(i==nums[i]) return i;
        }
        return -1;
    }
}
