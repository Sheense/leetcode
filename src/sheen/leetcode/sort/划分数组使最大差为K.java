package sheen.leetcode.sort;

import java.util.Arrays;

/**
 * @Classname 划分数组使最大差为K
 * @Date 2022/6/5 11:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 划分数组使最大差为K {
    public static void main(String[] args) {
        划分数组使最大差为K s = new 划分数组使最大差为K();
        System.out.println(s.partitionArray(new int[]{3,6,1,2,5}, 2));
    }
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int res = 0;
        while (i < nums.length) {
            int index = i;
            while (index < nums.length && nums[i] + k >= nums[index]) {
                index++;
            }
            res++;
            i = index;
        }

        return res;
    }
}
