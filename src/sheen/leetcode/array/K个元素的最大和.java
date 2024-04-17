package sheen.leetcode.array;

/**
 * @Classname K个元素的最大和
 * @Date 2023/11/15 00:03
 * @Created by sheen
 * @Description TODO
 */
public class K个元素的最大和 {
    public int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for(int num : nums) {
            max = Math.max(max, num);
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res += max + i;
        }
        return res;
    }
}
