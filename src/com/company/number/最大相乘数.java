package com.company.number;

import java.util.ArrayList;
import java.util.List;

public class 最大相乘数 {
    public static void main(String[] args) {
        最大相乘数 s = new 最大相乘数();
        System.out.print(s.maxProduct(new int[]{2,3,-2,4}));
    }

    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int all = 1;
        int item = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0 ) {
                if(item==0) {
                    all *= nums[i];
                } else {
                    max = item*nums[i]*all>max?item*nums[i]*all : max;
                    item *= nums[i];
                }
            } else if(nums[i]<0){
                if(item!=0) {
                    if(all>0) {
                        max = all*item*nums[i]>max?all*item*nums[i]:max;
                        all = all*item;
                    } else {
                        all = item ;
                        max = item *nums[i]>max ? all : max;
                    }
                }
                item = nums[i];
            } else {
                item = 0;
                all = 1;
            }

        }
        return max;
    }
}
