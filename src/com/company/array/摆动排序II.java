package com.company.array;

import com.company.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

public class 摆动排序II {

    public static void main(String[] args) {
        摆动排序II s = new 摆动排序II();
        int [] nums = {1, 3, 2, 2, 3, 1};
        s.wiggleSort(nums);
        ArrayUtils.print(nums);
    }
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int end1 = nums.length%2==0?nums.length/2-1:nums.length/2;
        int end2 = nums.length-1;
        int[] cp = new int[nums.length];
        int index = 0;
        while(end1>=0) {
            cp[index++] = nums[end1--];
            if(end1==-1&&nums.length%2==1) break;
            cp[index++] = nums[end2--];
        }
        for(int i=0;i<nums.length;i++) {
            nums[i] = cp[i];
        }
    }
}
