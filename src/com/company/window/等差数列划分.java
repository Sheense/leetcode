package com.company.window;

/**
 * @Classname 等差数列划分
 * @Date 2021/8/10 12:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            while (right + 1 < nums.length && nums[right+1] - nums[right] == diff) {
                right++;
            }

            for(int i = 3; i <= right - left+1; i++) {
                res += (right - left + 1) - i + 1;
            }


            left = right;
            right ++;
        }
        return res;
    }
}
