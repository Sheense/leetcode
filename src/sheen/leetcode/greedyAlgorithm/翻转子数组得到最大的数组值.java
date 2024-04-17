package sheen.leetcode.greedyAlgorithm;

/**
 * @Classname 翻转子数组得到最大的数组值
 * @Date 2023/5/12 12:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 翻转子数组得到最大的数组值 {
    public int maxValueAfterReverse(int[] nums) {
        int v1 = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            v1 += Math.abs(nums[i] - nums[i + 1]);
        }

        int mx1 = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            mx1 = Math.max(mx1, Math.abs(nums[i + 1] - nums[0]) - Math.abs(nums[i + 1] - nums[i]));
            mx1 = Math.max(mx1, Math.abs(nums[nums.length - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
        }

        int mx2 = Integer.MIN_VALUE;
        int mi2 = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i++) {
            mx2 = Math.max(mx2, Math.min(nums[i], nums[i+1]));
            mi2 = Math.min(mi2, Math.max(nums[i], nums[i+1]));
        }
        return v1 + Math.max(mx1, 2 * (mx2 - mi2));
    }
}
