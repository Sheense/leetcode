package sheen.leetcode.array;

/**
 * @Classname 找到数组的中间位置
 * @Date 2021/9/4 10:33 下午
 * @Created by sheen
 * @Description TODO
 */
public class 找到数组的中间位置 {
    public int findMiddleIndex(int[] nums) {
        for(int i = 0; i<nums.length; i++) {
            if(i != 0) {
                nums[i] += nums[i-1];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            int left = i == 0 ? 0 : nums[i-1];
            int right = nums[nums.length-1] - nums[i];
            if(left == right) {
                return i;
            }
        }
        return -1;
    }
}
