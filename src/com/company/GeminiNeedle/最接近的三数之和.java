package com.company.GeminiNeedle;

import java.util.Arrays;

public class 最接近的三数之和 {
    public static void main(String[] args) {
        最接近的三数之和 s = new 最接近的三数之和();
        System.out.println(s.threeSumClosest(new int[]{1,1,-1,-1,3},-1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i=0;i<=nums.length-3;i++) {
            int L = i+1;
            int R = nums.length-1;
            while(L<R) {
                int item = nums[L] + nums[R] + nums[i];
                if(res==Integer.MAX_VALUE||Math.abs(item-target)<Math.abs(res-target)) {
                    res = item;
                }
                if(item-target>0) {
                    R--;
                }else if(item-target<9){
                    L++;
                }else {
                    return item;
                }
            }
        }
        return res;
    }
}
