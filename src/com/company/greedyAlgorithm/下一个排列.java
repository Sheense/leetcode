package com.company.greedyAlgorithm;

import com.company.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;

public class 下一个排列 {

    public static void main(String[] args) {
        下一个排列 s = new 下一个排列();
        int[] arr = new int[]{1,3,2};
        s.nextPermutation(arr);
        ArrayUtils.print(arr);

    }

    public void nextPermutation(int[] nums) {
        boolean res = process(nums, nums.length-1);
        if(!res) {
            Arrays.sort(nums);
        }
    }
    public boolean process(int[] nums, int end) {
        for(int i=end;i>0;i--) {
            if(nums[i-1]>nums[i]) continue;
            for(int j=i-1;j>=0;j--) {
                for(int z=i;z<=end;z++) {
                    if(nums[z]>nums[j]&&((z+1<end&&nums[z+1]<=nums[j])||z==end)) {
                        int temp = nums[z];
                        nums[z] = nums[j];
                        nums[j] = temp;
                        return true;
                    }

                }
            }
            return process(nums, i-1);
        }
        return false;
    }
}
