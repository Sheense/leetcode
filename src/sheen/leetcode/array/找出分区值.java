package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 找出分区值
 * @Date 2024/7/26 00:36
 * @Created by sheen
 * @Description TODO
 */
public class 找出分区值 {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i++) {
            min = Math.min(min, nums[i + 1] - nums[i] );
        }
        return min;
    }
}
