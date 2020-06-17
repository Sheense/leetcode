package com.company.array;

import java.util.ArrayList;
import java.util.List;

public class 汇总区间 {

    public static void main(String[] args) {
        汇总区间 s= new 汇总区间();
        System.out.println(s.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i<nums.length) {
            int start = nums[i];
            int now = nums[i];
            while(i+1<nums.length&&now+1==nums[i+1]) {
                i++;
                now = nums[i];
            }
            if(now == start) {
                res.add(String.valueOf(now));
            }else {
                res.add(start+"->"+now);
            }
            i++;
        }
        return res;
    }
}
