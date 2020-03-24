package com.company.binarySearch;

import com.company.util.ArrayUtils;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        在排序数组中查找元素的第一个和最后一个位置 s = new 在排序数组中查找元素的第一个和最后一个位置();
        ArrayUtils.print(s.searchRange(new int[]{2,2},2) );

    }
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[] {-1,-1};
        return bin(0,nums.length-1, nums, target);
    }

    public int[] bin(int start,int end, int[] nums, int target) {
        if(start>end) return new int[]{-1,-1};
        int mid = (start + end)/2;
        if(nums[mid] == target) {
            int m = mid;
            int left = mid;
            int right = mid;
            while(--m>=0&&nums[left-1]==target) left--;
            m = mid;
            while(++m<nums.length&&nums[right+1]==target) right++;
            if(left==right) return new int[] {left,right};
            else return new int[] {left,right};
        } else if (nums[mid]>target){
            return bin(start, mid-1, nums, target);
        } else {
            return bin(mid+1, end, nums, target);
        }
    }
}
