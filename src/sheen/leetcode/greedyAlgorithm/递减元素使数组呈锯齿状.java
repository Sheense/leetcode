package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @Classname 递减元素使数组呈锯齿状
 * @Date 2023/2/27 9:48 上午
 * @Created by sheen
 * @Description TODO
 */
public class 递减元素使数组呈锯齿状 {

    public static void main(String[] args) {
        递减元素使数组呈锯齿状 s = new 递减元素使数组呈锯齿状();
        System.out.println(s.movesToMakeZigzag(new int[]{2,7,10,9,8,9}));
    }
    public int movesToMakeZigzag(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        return Math.min(getRes(nums, true), getRes(nums, false));


    }

    public int getRes(int[] nums, boolean odd) {
        nums = Arrays.copyOf(nums, nums.length);
        int res = 0;
        if(odd) {
            for(int i = 0; i < nums.length; i++) {
                if(i % 2 == 0) {
                    if(i - 1 >= 0 && nums[i - 1] >= nums[i]) {
                        res += nums[i - 1] - nums[i] + 1;
                        nums[i - 1] = nums[i] - 1;
                    }
                    if(i + 1 < nums.length && nums[i + 1] >= nums[i]) {
                        res += nums[i + 1] - nums[i] + 1;
                        nums[i + 1] = nums[i] - 1;
                    }
                }
            }
        }else {
            for(int i = 0; i < nums.length; i++) {
                if(i % 2 == 1) {
                    if(nums[i - 1] >= nums[i]) {
                        res += nums[i - 1] - nums[i] + 1;
                        nums[i - 1] = nums[i] - 1;
                    }
                    if(i + 1 < nums.length && nums[i + 1] >= nums[i]) {
                        res += nums[i + 1] - nums[i] + 1;
                        nums[i + 1] = nums[i] - 1;
                    }
                }
            }
        }

        return res;
    }
}
