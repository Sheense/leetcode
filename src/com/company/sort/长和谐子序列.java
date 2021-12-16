package com.company.sort;

import java.util.Arrays;

/**
 * @Classname 长和谐子序列
 * @Date 2021/11/20 1:48 下午
 * @Created by sheen
 * @Description TODO
 */
public class 长和谐子序列 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        boolean flag = false;
        int pre = 0;
        int preNum = 0;
        int index = 0;
        int max = 0;
        while (index < nums.length) {
            int i = index;
            while (index < nums.length && nums[i] == nums[index]){
                index++;
            }
            if(!flag) {
                pre = nums[i];
                preNum = index - i;
                flag = true;
            }else {
                int p = nums[i];
                int pN = index - i;
                if(Math.abs(pre - p) == 1) {
                    max = Math.max(preNum + pN, max);
                }
                pre = p;
                preNum = pN;
            }
        }
        return max;
    }
}
