package com.company.array;

public class 汉明距离总和 {

    public static void main(String[] args) {
        汉明距离总和 s = new 汉明距离总和();
        System.out.println(s.totalHammingDistance(new int[] {4, 14, 2}));
    }

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int [] bit = new int[31];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j <= 30; j++) {
                int a = nums[i] >> j;
                if (a % 2 == 1) bit[j] ++;
            }
        }
        int len = nums.length;
        for(int i = 0; i < 31; i++) {
            res += bit[i] * (len - bit[i]);
        }
        return res;
    }

}
