package com.company.array;

public class 错误的集合 {

    public int[] findErrorNums(int[] nums) {
        int [] n = new int[nums.length];
        int [] res = new int[2];
        for(int i=0;i<nums.length;i++) {
            if(n[nums[i]-1]==0) {
                n[nums[i]-1] = nums[i];
            }else {
                res[0] = nums[i];
            }
        }
        for(int i=0;i<n.length;i++) {
            if(n[i]==0) {
                res[1] = i+1;
                break;
            }
        }
        return res;
    }
}
