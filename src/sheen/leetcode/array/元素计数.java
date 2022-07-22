package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 元素计数
 * @Date 2022/1/23 11:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 元素计数 {
    public static void main(String[] args) {
        元素计数 s = new 元素计数();
        System.out.println(s.countElements(new int[]{-89,39,39,-89,39,39}));
    }
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int index = 0;
        while (index < nums.length && nums[index] == nums[0]) {
            index++;
            count++;
        }

        if(count == nums.length) {
            return 0;
        }

        int index1 = nums.length - 1;
        while (index1 > index && nums[index1] == nums[nums.length - 1]) {
            index1--;
            count++;
        }
        return nums.length - count;
    }
}
