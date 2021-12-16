package com.company.math;

/**
 * @Classname 最小操作次数使数组元素相等
 * @Date 2021/10/20 1:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最小操作次数使数组元素相等 {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(min > nums[i]) min = nums[i];
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res += (nums[i] - min);
        }
        return res;
    }
}
