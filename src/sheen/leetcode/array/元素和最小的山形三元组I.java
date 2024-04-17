package sheen.leetcode.array;

/**
 * @Classname 元素和最小的山形三元组I
 * @Date 2024/3/29 00:08
 * @Created by sheen
 * @Description TODO
 */
public class 元素和最小的山形三元组I {
    public int minimumSum(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - 3; i++) {
            for(int j = i + 1; j <= nums.length - 2; j++) {
                if(nums[i] < nums[j]) {
                    for (int z = j + 1; z <= nums.length - 1; z++) {
                        if(nums[j] > nums[z]) {
                            res = Math.min(res, nums[i] + nums[j] + nums[z]);
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
