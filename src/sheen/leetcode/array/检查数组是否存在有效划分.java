package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 检查数组是否存在有效划分
 * @Date 2022/8/7 10:56 上午
 * @Created by sheen
 * @Description TODO
 */
public class 检查数组是否存在有效划分 {
    public static void main(String[] args) {
        检查数组是否存在有效划分 s = new 检查数组是否存在有效划分();
        System.out.println(s.validPartition(new int[]{676575,676575,676575,533985,533985,40495,40495,40495,40495,40495,40495,40495,782020,782021,782022,782023,782024,782025,782026,782027,782028,782029,782030,782031,782032,782033,782034,782035,782036,782037,782038,782039,782040,378070,378070,378070,378071,378072,378073,378074,378075,378076,378077,378078,378079,378080,378081,378082,378083,378084,378085,378086,378087,378088,378089,378090,378091,378092,378093,129959,129959,129959,129959,129959,129959}));
    }
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        for(int i = 1; i < dp.length; i++) {
            if(i == 8){
                System.out.println(i);
            }
            if(i == 1) {
                dp[i] = nums[i] == nums[i - 1];
            }else if(i == 2){
                dp[i] = (nums[i-2] + 1 == nums[i - 1] && nums[i-1] + 1 == nums[i]) || (nums[i-2] == nums[i] && nums[i-1] == nums[i]);
            }else {
                if((nums[i-2] + 1 == nums[i - 1] && nums[i-1] + 1 == nums[i]) || (nums[i-2] == nums[i] && nums[i-1] == nums[i])) {
                    dp[i] |= dp[i-3];
                }

                if(nums[i - 1]  == nums[i]) {
                    dp[i] |= dp[i-2];
                }
            }
        }
        ArrayUtils.print(dp);
        return dp[nums.length - 1];
    }


}
