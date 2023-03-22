package sheen.leetcode.math;

/**
 * @Classname 全局倒置与局部倒置
 * @Date 2022/11/16 12:34 上午
 * @Created by sheen
 * @Description TODO
 */
public class 全局倒置与局部倒置 {
    public boolean isIdealPermutation(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
