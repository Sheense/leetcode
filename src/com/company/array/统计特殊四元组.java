package com.company.array;

/**
 * @Classname 统计特殊四元组
 * @Date 2021/9/5 1:06 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计特殊四元组 {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        for(int i = 0; i <= nums.length - 4; i++) {
            for(int j = i+1; j <= nums.length - 3; j++) {
                for(int z = j+1; z <= nums.length - 2; z++) {
                    for(int q = z+1; q <= nums.length - 1; q++) {
                        if(nums[i] + nums[j] + nums[z] == nums[q]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
