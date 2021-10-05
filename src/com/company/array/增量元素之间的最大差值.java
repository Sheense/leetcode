package com.company.array;

/**
 * @Classname 增量元素之间的最大差值
 * @Date 2021/9/26 10:45 上午
 * @Created by sheen
 * @Description TODO
 */
public class 增量元素之间的最大差值 {
    public int maximumDifference(int[] nums) {
        int res = -1;
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    res = Math.max(res, nums[j] - nums[i]);
                }
            }
        }
        return res;
    }
}
