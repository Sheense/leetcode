package com.company.sort;

import java.util.Arrays;

/**
 * @Classname 三大的数
 * @Date 2021/10/6 1:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 三大的数 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1;
        int count = 0;
        while (i >= 0) {
            count++;
            if(count == 3) {
                return nums[i];
            }
            int index = i;
            while (i >= 0 && nums[index] == nums[i]) {
                i--;
            }
        }
        return nums[nums.length - 1];
    }
}
