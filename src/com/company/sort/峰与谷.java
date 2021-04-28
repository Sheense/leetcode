package com.company.sort;

import java.util.Arrays;

public class 峰与谷 {
    public void wiggleSort(int[] nums) {
        int copy[] = new int[nums.length];
        for(int i=0;i<copy.length;i++) copy[i] = nums[i];
        Arrays.sort(copy);
        int i = 0;
        int j = nums.length - 1;
        int index = 0;
        while (index<nums.length) {
            nums[index++] = copy[i++];
            if(index==nums.length) break;
            nums[index++] = copy[j--];
        }
    }
}
