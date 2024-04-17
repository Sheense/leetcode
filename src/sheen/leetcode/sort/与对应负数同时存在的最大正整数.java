package sheen.leetcode.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Classname 与对应负数同时存在的最大正整数
 * @Date 2023/5/13 4:53 下午
 * @Created by sheen
 * @Description TODO
 */
public class 与对应负数同时存在的最大正整数 {
    public static void main(String[] args) {
        与对应负数同时存在的最大正整数 s = new 与对应负数同时存在的最大正整数();
        System.out.println( Arrays.binarySearch(new int[]{-10,8,6,7,-2,-3}, -8));
    }
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 0 && nums[i] > 0; i++) {
            int index = Arrays.binarySearch(nums, -nums[i]);
            if(index >= 0){
                return nums[i];
            }
        }
        return -1;
    }
}
