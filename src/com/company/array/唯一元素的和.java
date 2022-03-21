package com.company.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 唯一元素的和
 * @Date 2022/2/6 11:48 上午
 * @Created by sheen
 * @Description TODO
 */
public class 唯一元素的和 {
    public int sumOfUnique(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int res = 0;
        while (i < nums.length) {
            int index = i;
            while (index < nums.length && nums[i] == nums[index]) {
                index++;
            }
            if(index - i == 1) {
                res+= nums[i];
            }
            i = index;
        }
        return res;
    }
}
