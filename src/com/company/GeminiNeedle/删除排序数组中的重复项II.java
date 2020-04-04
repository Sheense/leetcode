package com.company.GeminiNeedle;

import com.company.util.ArrayUtils;

import java.sql.Array;

public class 删除排序数组中的重复项II {
    public static void main(String[] args) {
        删除排序数组中的重复项II s = new 删除排序数组中的重复项II();
        int[] arr = {1,1,1,2,2,3};
        System.out.println(s.removeDuplicates(arr));
        ArrayUtils.print(arr);
    }
    public int removeDuplicates(int[] nums) {
        int end = -1;
        int i = 0;
        while(i<nums.length)  {
            int index = i;
            while(i<nums.length&&nums[index]==nums[i]) i++;
            if(i-index>=2) {
                nums[++end] = nums[index];
                nums[++end] = nums[index];
            }else {
                nums[++end] = nums[index];
            }
        }
        return end+1;
    }
}
