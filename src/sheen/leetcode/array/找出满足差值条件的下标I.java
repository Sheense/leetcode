package sheen.leetcode.array;

/**
 * @Classname 找出满足差值条件的下标I
 * @Date 2024/5/25 01:57
 * @Created by sheen
 * @Description TODO
 */
public class 找出满足差值条件的下标I {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + indexDifference; j < nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
