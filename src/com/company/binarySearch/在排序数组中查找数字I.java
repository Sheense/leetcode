package com.company.binarySearch;

/**
 * @Classname 在排序数组中查找数字I
 * @Date 2021/7/16 12:32 上午
 * @Created by sheen
 * @Description TODO
 */
public class 在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        int left1 = 0;
        int right1 = nums.length - 1;
        while (left1 <= right1) {
            int mid = (left1 + right1) / 2;
            if(nums[mid] >= target) {
                right1 = mid - 1;
            }else {
                left1 = mid + 1;
            }
        }

        int left2 = 0;
        int right2 = nums.length - 1;
        while (left2 <= right2) {
            int mid = (left2 + right2) / 2;
            if(nums[mid] > target) {
                right2 = mid - 1;
            }else {
                left2 = mid + 1;
            }
        }
        return left2 - left1;
    }
}
