package com.company.sort;

import com.company.util.ArrayUtils;

public class 三路排序_快排 {

    public static void main(String[] args) {
        三路排序_快排 s = new 三路排序_快排();
        int[] nums = new int[]{1,2,3,8,5,1,2,35,4,6,7,59,8};
        s.quick_sort(0, nums.length-1, nums);
        ArrayUtils.print(nums);
    }
    public void sortColors(int[] nums) {
        int i0 = -1;
        int i1 = 0;
        int i2 = nums.length;
        while (i1<i2) {
            if(nums[i1] < 1) {
                i0++;
                if(i1 == i0) i1++;
                else {
                    nums[i1] = nums[i0];
                    nums[i0] = 0;
                }
            }else if(nums[i1] > 1) {
                i2 ++;
                nums[i1] = nums[i2];
                nums[i2] = 2;
            } else {
                i1++;
            }
        }
    }
//快排，选中的数字排后的结果是集中在中间
    public void quick_sort(int start, int end, int[] nums) {
        if(start>=end) return ;
        int left = start - 1;
        int right = end + 1;
        int mid = start;
        int midNum = nums[mid];
        while(mid <right) {
            if(nums[mid] == midNum) {
                mid ++;
            } else if(nums[mid] < midNum) {
                left++;
                int item = nums[mid];
                nums[mid] = nums[left];
                nums[left] = item;
            } else {
                right--;
                int item = nums[mid];
                nums[mid] = nums[right];
                nums[right] = item;
            }
        }
        quick_sort(start, left, nums);
        quick_sort(right, end, nums);
    }
}
