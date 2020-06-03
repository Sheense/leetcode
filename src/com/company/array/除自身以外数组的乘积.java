package com.company.array;

import com.company.util.ArrayUtils;

public class 除自身以外数组的乘积 {

    public static void main(String[] args) {
        除自身以外数组的乘积 s= new 除自身以外数组的乘积();
        ArrayUtils.print(s.productExceptSelf(new int[]{1,2}));
    }
    public int[] productExceptSelf(int[] nums) {
        int[] n = new int[nums.length];
        int value = 1;
        for(int i=0;i<nums.length;i++) {
            n[i] = value;
            value *= nums[i];
        }
        value = 1;
        for(int i=nums.length-1;i>=0;i--) {
            int item = nums[i];
            nums[i] = value * n[i];
            value *= item;
        }
        return nums;
    }
}
