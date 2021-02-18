package com.company.array;

public class 子数组最大平均数I {
    public double findMaxAverage(int[] nums, int k) {
        int index = 0;
        double res = Integer.MIN_VALUE;
        double window = 0;
        while (index<=nums.length) {
            if(index==0){
                while(index<k) {
                    window+=nums[index++];
                }
            }
            res = Math.max(res, window/k);
            if(index==nums.length) break;
            window += nums[index];
            window -= nums[index-k];
            index++;
        }
        return res;
    }
}
