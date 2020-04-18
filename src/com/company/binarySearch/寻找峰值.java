package com.company.binarySearch;

public class 寻找峰值 {

    public static void main(String[] args) {
        寻找峰值 s = new 寻找峰值();
        int[] a = new int[]{1,2,1,3,5,6,4};
        System.out.println(s.findPeakElement(a));
    }
    public int findPeakElement(int[] nums) {
        return binarySearch(nums,0,nums.length-1);
    }

    public int binarySearch(int[] nums, int start,int end) {
        if(start>end) return -1;
        int mid = (start+end)/2;
        if((mid-1<0||nums[mid-1]<nums[mid])&&(mid+1>=nums.length||nums[mid+1]<nums[mid])) {
            return mid;
        }
        int res = binarySearch(nums, start, mid-1);
        if(res==-1) res =  binarySearch(nums, mid+1, end);
        return res;
    }
}
