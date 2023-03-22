package sheen.leetcode.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Classname 分割数组
 * @Date 2022/10/24 12:37 上午
 * @Created by sheen
 * @Description TODO
 */
public class 分割数组 {
    public static void main(String[] args) {
        分割数组 s = new 分割数组();
        System.out.println(s.partitionDisjoint(new int[]{5,0,3,6,8}));
    }
    public int partitionDisjoint(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        max[0] = nums[0];
        min[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
            min[nums.length - 1 - i] = Math.min(min[nums.length - i], nums[nums.length - 1 - i]);
        }

        for(int i = 0; i < max.length - 1; i++) {
            if(max[i] <= min[i + 1]) {
                return i + 1;
            }
        }

        return nums.length;
    }
}
