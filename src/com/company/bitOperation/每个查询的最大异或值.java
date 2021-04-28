package com.company.bitOperation;

import com.company.util.ArrayUtils;

public class 每个查询的最大异或值 {
    public static void main(String[] args) {
        每个查询的最大异或值 s = new 每个查询的最大异或值();
        ArrayUtils.print(s.getMaximumXor(new int[]{0,1,1,3}, 2));
    }
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int all = 0;
        for(int i=0;i<nums.length;i++) all ^= nums[i];
        int i = nums.length - 1;
        while (i>=0) {
            int item = all;
            int k = 0;
            for(int j = 0; j < 31; j++) {
                if((item & 1) == 0 && j<maximumBit) {
                    k |= (1<<j);
                }
                item >>= 1;
            }
            res[nums.length - 1 - i] = k;
            all ^= nums[i];
            i--;
        }
        return res;
    }
}
