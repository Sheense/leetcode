package com.company.dp;

public class 乘积最大子序列 {
    public static void main(String[] args) {
        乘积最大子序列 s = new 乘积最大子序列();
        System.out.println(s.maxProduct(new int[]{2,-5,-2,-4,3}));
    }
    /*
       当i为n时，p与n保留从n-1到0中绝对值最大正负数的子序列
     */
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int res = Integer.MIN_VALUE;
        int max[] = new int[nums.length];
        int min[] = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(i==0) {
                if(nums[i]>0) {
                    max[i] = nums[i];
                } else if(nums[i]<0) {
                  min[i] = nums[i];
                }
                if(res<max[i]) res = max[i];
                continue;
            }
            if(nums[i]>0) {
                max[i] = max[i-1]!=0 ?  max[i-1]*nums[i] : nums[i];
                min[i] = min[i-1]!=0 ? min[i-1]*nums[i] : 0;
            } else if(nums[i]<0) {
                max[i] = min[i-1]!=0?min[i-1]*nums[i] : 0;
                min[i] = max[i-1]!=0?max[i-1]*nums[i] : nums[i];
            } else {
                max[i] = 0;
                min[i] = 0;
            }
            if(res<max[i]) res = max[i];
        }
        return res;
    }
}
