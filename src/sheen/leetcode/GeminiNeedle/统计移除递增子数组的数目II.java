package sheen.leetcode.GeminiNeedle;

/**
 * @Classname 统计移除递增子数组的数目II
 * @Date 2024/7/11 00:47
 * @Created by sheen
 * @Description TODO
 */
public class 统计移除递增子数组的数目II {

    public long incremovableSubarrayCount(int[] nums) {
        int left = 0;
        int n = nums.length;
        while (left + 1 < nums.length && nums[left + 1] > nums[left]) {
            left++;
        }

        if(left == nums.length - 1) {
           return  (long) n * (n + 1) / 2;
        }

        long res = left + 2;
        for(int right = n - 1; right >= 0; right--) {
            if(right + 1 < n && nums[right + 1] <= nums[right]) {
                break;
            }

            while (left >= 0 && nums[left] >= nums[right]) {
                left--;
            }
            res += left + 2;
        }
        return res;
    }
}
