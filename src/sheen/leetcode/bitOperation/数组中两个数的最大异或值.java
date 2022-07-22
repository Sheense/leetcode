package sheen.leetcode.bitOperation;

import java.util.HashSet;
import java.util.Set;

public class 数组中两个数的最大异或值 {
    /*public int findMaximumXOR(int[] nums) {
        if(nums.length == 1) return nums[0];
        int res = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++) {
            for(int j = i+1;j<nums.length;j++) {
                if((nums[i]^nums[j]) >res ) {
                    res = nums[i]^nums[j];
                }
            }
        }
        return res;
    }*/
    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for(int k = 30; k>=0;k--) {
            Set<Integer> set = new HashSet<>();
            x <<= 1;
            x ++;
            for(int i=0;i<nums.length;i++) {
                set.add(nums[i] >> k);
            }
            boolean flag = false;
            for(int num:set) {
                if(set.contains(num ^ x)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) x--;
        }
        return x;
    }
}
