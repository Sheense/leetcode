package com.company.binarySearch;

import com.company.queue.单线程CPU;

/**
 * @Classname 有序数组中的单一元素
 * @Date 2022/2/14 12:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(mid + 1 < nums.length && nums[mid + 1] == nums[mid]) {
                int count = nums.length - mid;
                if(count % 2 == 0) {
                    right = mid - 1;
                }else {
                    left = mid + 2;
                }
            }else if(mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                int count = nums.length - 1 - mid;
                if(count % 2 == 0) {
                    right = mid - 2;
                }else {
                    left = mid + 1;
                }
            }else {
                return nums[mid];
            }
        }
        return 0;
    }
}
