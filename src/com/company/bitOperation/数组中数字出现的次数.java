package com.company.bitOperation;

import com.company.util.ArrayUtils;

public class 数组中数字出现的次数 {

    public static void main(String[] args) {
        数组中数字出现的次数 s = new 数组中数字出现的次数();
        ArrayUtils.print(s.singleNumbers(new int[]{1,6,10,4,1,4,3,3}));
    }

    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        if(nums.length==0) return res;
        int num = nums[0];
        for(int i=1;i<nums.length;i++) {
            num ^= nums[i];
        }
        int index = 0;
        while(((1<<index)&num)==0) {
            index++;
        }
        res[0] = num;
        res[1] = num;
        for(int i=0;i<nums.length;i++) {
            if(((1<<index)&nums[i])!=0) {
                res[0] ^= nums[i];
            }else {
                res[1] ^=nums[i];
            }
        }
        return res;
    }
}
