package com.company.array;

public class 绝对差不超过限制的最长连续子数组 {

    public static void main(String[] args) {
        绝对差不超过限制的最长连续子数组 s = new 绝对差不超过限制的最长连续子数组();
        System.out.println(s.longestSubarray(new int[]{10,1,2,4,7,2},5));
    }

    public int longestSubarray(int[] nums, int limit) {
        int length = 1;
        int maxIndex = 0;
        int minIndex = 0;
        int res = 1;
        int i = 1;
        while(i<nums.length) {
            if(Math.abs(nums[i]-nums[maxIndex])<=limit&&Math.abs(nums[i]-nums[minIndex])<=limit) {
                length ++;
                if(nums[i]>=nums[maxIndex]) maxIndex = i;
                if(nums[i]<=nums[minIndex]) minIndex = i;
                if(res<length) res = length;
            }else if (nums[i]>nums[maxIndex]&&Math.abs(nums[i]-nums[maxIndex])>limit){
                maxIndex = i;
                minIndex = i;
                length = 1;
            }else if(nums[i]<nums[minIndex]&&Math.abs(nums[i]-nums[minIndex])>limit) {
                maxIndex = i;
                minIndex = i;
                length = 1;
            }else if(Math.abs(nums[i]-nums[minIndex])>limit) {
                maxIndex = ++minIndex;
                length = 1;
                i = maxIndex;
            }else if(Math.abs(nums[i]-nums[maxIndex])>limit){
                minIndex = ++maxIndex;
                length = 1;
                i = minIndex;
            }
            i++;
        }
        return res;
    }
}
