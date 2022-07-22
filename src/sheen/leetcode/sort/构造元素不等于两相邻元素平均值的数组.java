package sheen.leetcode.sort;

import java.util.Arrays;

/**
 * @Classname 构造元素不等于两相邻元素平均值的数组
 * @Date 2021/8/15 11:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 构造元素不等于两相邻元素平均值的数组 {
    public static void main(String[] args) {
        构造元素不等于两相邻元素平均值的数组 s = new 构造元素不等于两相邻元素平均值的数组();
        System.out.println(s.rearrangeArray(new int[]{1,2,3,4,5}));
    }
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        int res[] = new int[nums.length];
        int left = 0;
        int right = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        while (index < nums.length) {
            res[index++] = nums[left++];
            if(index >= nums.length) break;
            res[index++] = nums[right++];
        }
        return res;
    }
}
