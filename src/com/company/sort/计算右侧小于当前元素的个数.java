package com.company.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 计算右侧小于当前元素的个数 {

    public static void main(String[] args) {
        计算右侧小于当前元素的个数 s = new 计算右侧小于当前元素的个数();
        System.out.println(s.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
    }
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        sort(nums,res,0,nums.length-1);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<res.length;i++) {
            list.add(res[i]);
        }
        return list;
    }

    public void sort(int [] nums,int [] res, int start, int end) {
        if(start>=end) {
            return;
        }
        int mid = (start+end)/2;
        sort(nums,res,mid+1,end);
        for(int i = start;i<=mid;i++) {
            if(i==7) {
                System.out.println();
            }
            int left = mid+1;
            int right = end;
            while(left<=right) {
                int m = (left+right)/2;
                if(nums[m]>nums[i]) {
                    right = m-1;
                }else if(nums[m]<nums[i]){
                    left = m + 1;
                }else {
                    break;
                }
            }
            while(right>=mid+1&&nums[right]>=nums[i]) right--;
            res[i] += right-(mid+1)+1;
        }
        sort(nums,res,start,mid);
        Arrays.sort(nums,start,end+1);
    }
}

