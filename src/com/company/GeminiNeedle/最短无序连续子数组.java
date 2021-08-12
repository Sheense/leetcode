package com.company.GeminiNeedle;

/**
 * @Classname 最短无序连续子数组
 * @Date 2021/8/3 12:27 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最短无序连续子数组 {
    public static void main(String[] args) {
        最短无序连续子数组 s = new 最短无序连续子数组();
        System.out.println(s.findUnsortedSubarray(new int[]{2,3,3,2,4}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        int min = Integer.MAX_VALUE;
        int right = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(min >= nums[nums.length - i -1]) {
                min = nums[nums.length - i - 1];
            }else {
                left = nums.length - i - 1;
            }
            if(max >  nums[i]) {
                right = i;
            }else {
                max = nums[i];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
