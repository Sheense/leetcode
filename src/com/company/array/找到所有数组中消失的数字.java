package com.company.array;

import java.util.ArrayList;
import java.util.List;

public class 找到所有数组中消失的数字 {

    public static void main(String[] args) {
        找到所有数组中消失的数字 s = new 找到所有数组中消失的数字();
        System.out.println(s.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res  = new ArrayList<>();
        int i = 0;
        while(i<nums.length) {
            if(nums[i]!=i+1&&nums[i]!=-1) {
                int key = nums[i]-1;
                nums[i]=-1;
                while(key>=0&&nums[key]!=key+1) {
                    int item = nums[key]-1;
                    nums[key] = key+1;
                    key = item;
                }
            }
            i++;
        }
        for(int j=0;j<nums.length;j++) {
            if(nums[j]==-1) res.add(j+1);
        }
        return res;
    }
}
