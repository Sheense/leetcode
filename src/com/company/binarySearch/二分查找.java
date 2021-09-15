package com.company.binarySearch;

/**
 * @Classname 二分查找
 * @Date 2021/9/6 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二分查找 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
