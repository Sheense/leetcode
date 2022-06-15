package com.company.recall;

/**
 * @Classname 极大极小游戏
 * @Date 2022/6/5 11:01 上午
 * @Created by sheen
 * @Description TODO
 */
public class 极大极小游戏 {
    public int minMaxGame(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        return min(nums, 0, nums.length - 1);
    }

    public int min(int[] nums, int start, int end) {
        if(end - start + 1 == 2) {
            return Math.min(nums[start], nums[end]);
        }

        int mid = (end - start) / 2;
        int min = min(nums, start, start + mid);
        int max = max(nums, start + mid + 1, end);
        return Math.min(min, max);
    }

    public int max(int[] nums, int start, int end) {
        if(end - start + 1 == 2) {
            return Math.max(nums[start], nums[end]);
        }

        int mid = (end - start) / 2;
        int min = min(nums, start, start + mid);
        int max = max(nums, start + mid + 1, end);
        return Math.max(min, max);
    }
}
