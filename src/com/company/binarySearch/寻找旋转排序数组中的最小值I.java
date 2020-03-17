package com.company.binarySearch;

public class 寻找旋转排序数组中的最小值I {
    public static void main(String[] args) {
        寻找旋转排序数组中的最小值I s = new 寻找旋转排序数组中的最小值I();
        System.out.println(s.findMin(new int[]{3,1,1,1,1}));
    }
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        Integer res = bin(0, nums.length-1, nums);
        return res==null?nums[0] : res;
    }
    public Integer bin (int start, int end, int[] nums) {
        if(start>end) return null;
        int mid = (start+end)/2;
        int left = mid;
        while(left-1>0&&nums[left-1]==nums[mid]) left--;
        if(left-1>=0 && nums[left]<nums[left-1]) return nums[left];
        int right = mid;
        while(right+1<nums.length&&nums[right+1]==nums[mid]) right++;
        if(right+1<nums.length&&nums[right+1]<nums[right]) return nums[right+1];
        Integer res = bin(start,left-1,nums);

        return res!=null ? res : bin(right+1,end,nums);
    }
}
