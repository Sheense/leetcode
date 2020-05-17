package com.company.array;

public class 乘积最大子数组 {

    public static void main(String[] args) {
        乘积最大子数组 s = new 乘积最大子数组();
        System.out.println(s.maxProduct(new int[]{-4,-3,-2}));
    }

    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int res = Integer.MIN_VALUE;
        int max = 0;
        int min = 0;
        for(int i=0;i<nums.length;i++) {
            if(i==0) {
                if(nums[i]>0) {
                    max = nums[i];
                } else if(nums[i]<0) {
                    min = nums[i];
                }
                if(res<max) res = max;
                continue;
            }
            if(nums[i]>0) {
                max = max!=0 ?  max*nums[i] : nums[i];
                min = min!=0 ? min*nums[i] : 0;
            } else if(nums[i]<0) {
                int item = max;
                max = min!=0?min*nums[i] : 0;
                min= item!=0?item*nums[i] : nums[i];
            } else {
                max = 0;
                min = 0;
            }
            if(res<max) res = max;
        }
        return res;
    }

}
