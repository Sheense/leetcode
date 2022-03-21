package com.company.array;

/**
 * @Classname 最少交换次数来组合所有的1II
 * @Date 2022/1/9 11:27 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最少交换次数来组合所有的1II {
    public static void main(String[] args) {
        最少交换次数来组合所有的1II s = new 最少交换次数来组合所有的1II();
        System.out.println(s.minSwaps(new int[]{0,1,0,1,1,0,0}));
    }
    public int minSwaps(int[] nums) {
        int[] arr = new int[nums.length];
        int max = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++ ){
            if(nums[i] == 0) {
                count++;
            }

            if(nums[i] == 0) {
                if(i == 0) {
                    arr[i] = 1;
                }else {
                    arr[i] = arr[i - 1] + 1;
                }
            }else {
                if(i > 0) {
                    arr[i] = arr[i-1];
                }
            }

        }


        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                int end = i + count - 1;
                int n = 0;
                if(end >= arr.length) {
                    n = arr[arr.length - 1] - (i - 1 < 0 ? 0 : arr[i - 1]) + arr[end % arr.length];
                }else {
                    n =  arr[end] - (i - 1 < 0 ? 0 : arr[i - 1]);
                }
                max = Math.max(n, max);
            }
        }

        return count - max;
    }
}
