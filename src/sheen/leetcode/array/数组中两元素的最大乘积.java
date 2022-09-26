package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 数组中两元素的最大乘积
 * @Date 2022/8/26 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 数组中两元素的最大乘积 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
