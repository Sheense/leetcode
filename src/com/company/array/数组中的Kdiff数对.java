package com.company.array;

import java.util.HashSet;
import java.util.Set;

public class 数组中的Kdiff数对 {

    public static void main(String[] args) {
        数组中的Kdiff数对 s = new 数组中的Kdiff数对();
        System.out.println(s.findPairs(new int[]{2,9,0,8,9,6,5,9,8,1,9,6,9,2,8,8,7,5,7,8,8,3,7,4,1,1,6,2,9,9,3,9,2,4,6,5,6,5,1,5,9,9,8,1,4,3,2,8,5,3,5,4,5,7,0,0,7,6,4,7,2,4,9,3,6,6,5,0,0,0,8,9,9,6,5,4,6,2,1,3,2,5,0,1,4,2,6,9,5,4,9,6,0,8,3,8,0,0,2,1},1));
    }
    public int findPairs(int[] nums, int k) {
        if(k<0) return 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> flag = new HashSet<>();
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            if(k==0&&set.contains(nums[i])&&!flag.contains(nums[i])) {
                flag.add(nums[i]);
                res++;
            }
            set.add(nums[i]);
        }
        if(k==0) return res;
        for(int value : set) {
            int diff1 = value - k;
            int diff2 = k + value;
            boolean f = false;
            if(set.contains(diff1)&&(!flag.contains(diff1)||!flag.contains(value))) {
                flag.add(diff1);
                f = true;
                res++;
            }
            if(set.contains(diff2)&&(!flag.contains(diff2)||!flag.contains(value))) {
                flag.add(diff2);
                f=true;
                res++;
            }
            if(f) flag.add(value);
        }
        return res;
    }
}
