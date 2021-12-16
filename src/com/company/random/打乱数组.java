package com.company.random;

import java.util.Random;

/**
 * @Classname 打乱数组
 * @Date 2021/11/22 12:32 上午
 * @Created by sheen
 * @Description TODO
 */
public class 打乱数组 {
    static class Solution {
        Random random = new Random();
        private int[] copy;
        private int[] nums;
        public Solution(int[] nums) {
            this.copy = new int[nums.length];
            this.nums = nums;
            for(int i = 0; i < nums.length; i++) {
                copy[i] = nums[i];
            }
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            for(int i = nums.length - 1; i > 1; i --) {
                int index = random.nextInt(i + 1);
                int swap = nums[i];
                nums[i] = nums[index];
                nums[index] = swap;
            }
            return nums;
        }
    }
}
