package com.company.window;

import com.company.util.ArrayUtils;

/**
 * @Classname 三个无重叠子数组的最大和
 * @Date 2021/12/8 12:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 三个无重叠子数组的最大和 {
    public static void main(String[] args) {
        三个无重叠子数组的最大和 s = new 三个无重叠子数组的最大和();
        ArrayUtils.print(s.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2));
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int maxSum1 = 0;
        int maxSum1Ind = -1;
        int maxSum2 = 0;
        int maxSum2Ind1 = -1;int maxSum2Ind2 = -1;
        int maxSum3 = 0;
        int[] res = null;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for(int i = 0; i <= nums.length - 3 * k; i++) {
            if(i == 0) {
                for(int j = 0; j < k; j++) {
                    sum1 += nums[i + j];
                    sum2 += nums[i + k + j];
                    sum3 += nums[i + 2 * k + j];
                }
                maxSum1 = sum1;
                maxSum2 = maxSum1 + sum2;
                maxSum3 = maxSum2 + sum3;
                maxSum1Ind = 0;
                maxSum2Ind1 = 0;
                maxSum2Ind2 = k;
                res = new int[]{0, k, 2 * k};
            }else {
                sum1 = sum1 - nums[i - 1] + nums[i + k - 1];
                sum2 = sum2 - nums[i - 1 + k] + nums[i + 2 * k - 1];
                sum3 = sum3 - nums[i - 1 + 2 * k] + nums[i + 3 * k - 1];
                if(sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Ind = i;
                }
                if(maxSum1 + sum2 > maxSum2) {
                    maxSum2 = maxSum1 + sum2;
                    maxSum2Ind1 = maxSum1Ind;
                    maxSum2Ind2 = i + k;
                }
                if(maxSum2 + sum3 > maxSum3) {
                    maxSum3 = maxSum2 + sum3;
                    res[0] = maxSum2Ind1;
                    res[1] = maxSum2Ind2;
                    res[2] =  i + 2 * k;
                }
            }
        }
        return res;
    }
}
