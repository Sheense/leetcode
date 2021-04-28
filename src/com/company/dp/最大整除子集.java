package com.company.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大整除子集 {
    public static void main(String[] args) {
        最大整除子集 s = new 最大整除子集();
        System.out.println(s.largestDivisibleSubset(new int[]{1}));
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for(int i=0;i<dp.length;i++) {
            dp[i][1] = -1;
            dp[i][0] = 1;
        }
        Arrays.sort(nums);
        int resIndex = -1;
        int resSize = 1;
        for(int i=0;i<nums.length;i++) {
            int maxIndex = -1;
            int maxValue = 1;
            for(int j = i-1;j>=0;j--) {
                if(nums[i]%nums[j]==0&&dp[j][0] > maxValue) {
                    maxIndex = j;
                    maxValue = dp[j][0];
                }
            }
            dp[i][0] += maxValue;
            dp[i][1] = maxIndex;
            if(dp[i][0]>1 && dp[i][0] > resSize) {
                resSize = dp[i][0];
                resIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        int index = resIndex;
        while (index!=-1) {
            res.add(nums[index]);
            index = dp[index][1];
        }
        return res;
    }
}
