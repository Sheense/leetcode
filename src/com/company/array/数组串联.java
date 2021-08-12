package com.company.array;

/**
 * @Classname 数组串联
 * @Date 2021/7/15 1:30 上午
 * @Created by sheen
 * @Description TODO
 */
public class 数组串联 {
    public int[] getConcatenation(int[] nums) {
        int [] res = new int[nums.length * 2];
        for(int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i+nums.length] = nums[i];
        }
        return res;
    }
}
