package com.company.array;

/**
 * @Classname 按奇偶排序数组
 * @Date 2022/4/28 12:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 按奇偶排序数组 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            if(nums[left] % 2 == 0) {
                left++;
            }else {
                int swap = nums[left];
                nums[left] = nums[right];
                nums[right] = swap;
                right--;
            }
        }
        return nums;
    }
}
