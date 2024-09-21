package sheen.leetcode.enums;

/**
 * @Classname 统计上升四元组
 * @Date 2024/9/10 00:37
 * @Created by sheen
 * @Description TODO
 */
public class 统计上升四元组 {
    public long countQuadruplets(int[] nums) {
        int[] pre = new int[nums.length + 1];
        long res = 0;
        for(int i = 0; i < nums.length; i++) {
            int suffix = 0;
            for(int j = nums.length - 1; j > i; j--) {
                if(nums[j] < nums[i]) {
                    res += (long)pre[nums[j]] * suffix;
                }

                if(nums[j] > nums[i]) {
                    suffix++;
                }
            }

            for(int j = nums[i] + 1; j <= nums.length; j++) {
                pre[j]++;
            }
        }

        return res;
    }
}
