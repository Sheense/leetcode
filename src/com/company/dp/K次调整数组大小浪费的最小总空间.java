package com.company.dp;

import java.util.Arrays;

/**
 * @Classname K次调整数组大小浪费的最小总空间
 * @Date 2021/8/8 1:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class K次调整数组大小浪费的最小总空间 {
    public static void main(String[] args) {
        K次调整数组大小浪费的最小总空间 s = new K次调整数组大小浪费的最小总空间();
        System.out.println(s.minSpaceWastedKResizing(new int[]{13,46,42,45,35}, 4));
    }
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int arr[] = new int[nums.length];
        int max[][] = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                arr[i] = nums[i];
            }
            else {
                arr[i] = nums[i] + arr[i-1];
            }
        }
        for(int i = 0; i < max.length; i++) {
            int m = nums[i];
            for(int j = i; j < max.length; j++) {
                if(nums[j] > m) {
                    m = nums[j];
                }
                max[i][j] = m;
            }
        }

        int[] dp = new int[nums.length];
        for(int i = 0; i <= k; i++) {
            int[] temp = new int[nums.length];
            Arrays.fill(temp, Integer.MAX_VALUE);
            if (i == 0) {
                for(int j = 0; j < max.length; j++) {
                    temp[j] = max[0][j] * (j + 1) - arr[j];
                }
            }else {
                for(int j = i; j < max.length; j++) {
                    for(int z = i - 1; z < j; z ++) {
                        int a = max[z+1][j] * (j - z);
                        int b = arr[j] - arr[z];
                        int num = dp[z] + a - b;
                        temp[j] = Math.min(num, temp[j]);
                    }
                }
            }
            dp = temp;
        }
        return dp[nums.length-1];
    }
}
