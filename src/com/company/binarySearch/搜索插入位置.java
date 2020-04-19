package com.company.binarySearch;

public class 搜索插入位置 {

    public static void main(String[] args) {
        搜索插入位置  s = new 搜索插入位置();
        System.out.println(s.searchInsert(new int[]{3,5,7,9,10},8));
    }

    public int searchInsert(int[] nums, int target) {
        if(nums.length==0) return 0;
        return binarySearch(nums,target,0,nums.length-1);
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if(start>=end) {
            if(target==nums[start]) return start;
            if(target>nums[start]) return start+1;
            if(target<nums[start]) return start;
        }
        int mid = (start+end)/2;
        if(nums[mid]==target) return mid;
        else if(nums[mid]<target) {
            return binarySearch(nums, target, mid+1,end);
        }else {
            return binarySearch(nums, target, start, mid-1);
        }
    }
}
