package com.company.array;

/**
 * @Classname 至少是其他数字两倍的最大数
 * @Date 2022/1/13 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 至少是其他数字两倍的最大数 {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(i != maxIndex) {
                if(nums[i] * 2 > nums[maxIndex]) {
                    return -1;
                }
            }
        }
        return maxIndex;
    }
}
