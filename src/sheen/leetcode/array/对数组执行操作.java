package sheen.leetcode.array;

/**
 * @Classname 对数组执行操作
 * @Date 2023/6/5 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 对数组执行操作 {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int[] res = new int[nums.length];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                res[index++] = nums[i];
            }
        }
        return res;
    }
}
