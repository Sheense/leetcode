package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @Classname 修改两个元素的最小分数
 * @Date 2023/5/6 10:25 上午
 * @Created by sheen
 * @Description TODO
 */
public class 修改两个元素的最小分数 {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(Math.min(nums[n - 3] - nums[0], nums[n - 1] - nums[2]), nums[n - 2] - nums[1]);
    }
}
