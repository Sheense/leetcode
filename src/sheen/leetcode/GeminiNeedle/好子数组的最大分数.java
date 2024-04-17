package sheen.leetcode.GeminiNeedle;

/**
 * @Classname 好子数组的最大分数
 * @Date 2024/3/19 00:38
 * @Created by sheen
 * @Description TODO
 */
public class 好子数组的最大分数 {
    public int maximumScore(int[] nums, int k) {
        int left = k - 1;
        int right = k + 1;
        int res = 0;
        for(int i = nums[k];; i--) {
            while (left >= 0 && nums[left] >= i) {
                left--;
            }
            while (right < nums.length && nums[right] >= i) {
                right++;
            }
            res = Math.max(res, (right - left - 1) * i);
            if(left == -1 && right == nums.length) {
                break;
            }
        }
        return res;
    }
}
