package com.company.array;

import java.util.HashSet;
import java.util.Set;

public class 数组嵌套 {

    public static void main(String[] args) {
        数组嵌套 s = new 数组嵌套();
        System.out.println(s.arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }

    public int arrayNesting(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            boolean[] flag = new boolean[nums.length];
            int index = i;
            int r = 0;
            while(!flag[nums[index]]) {
                r++;
                flag[nums[index]]=true;
                index = nums[index];
            }
            if(r>res) res = r;
        }
        return res;
    }
}
