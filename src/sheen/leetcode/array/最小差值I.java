package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 最小差值I
 * @Date 2022/4/30 12:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最小差值I {
    public static void main(String[] args) {
        最小差值I s = new 最小差值I();
        System.out.println(s.smallestRangeI(new int[]{1,3,6}, 3));
    }
    public int smallestRangeI(int[] nums, int k) {

        Arrays.sort(nums);
        int a = nums[nums.length - 1] - nums[0];
        if(a <= 2 * k) {
            return 0;
        }

        return a - 2 * k;
    }
}
