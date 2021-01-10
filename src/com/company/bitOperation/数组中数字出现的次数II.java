package com.company.bitOperation;

public class 数组中数字出现的次数II {
    public static void main(String[] args) {
        数组中数字出现的次数II s = new 数组中数字出现的次数II();
        System.out.println(s.singleNumber(new int[]{3,4,3,3}));
    }
    public int singleNumber(int[] nums) {
        int[] bit = new int[31];
        for(int i=0;i<nums.length;i++) {
            int item = nums[i];
            int j = 0;
            while(item!=0) {
                if((item&1)==1) {
                    bit[j]++;
                }
                j++;
                item = item>>1;
            }
        }
        int res = 0;
        int q = 1;
        for(int i=0;i<bit.length;i++) {
            res += (bit[i]%3)*q;
            q*=2;
        }
        return res;
    }
}
