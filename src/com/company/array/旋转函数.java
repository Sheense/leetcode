package com.company.array;

/**
 * @Classname 旋转函数
 * @Date 2022/4/22 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 旋转函数 {
    public static void main(String[] args) {
        旋转函数 s = new 旋转函数();
        System.out.println(s.maxRotateFunction(new int[]{100}));
    }
    public int maxRotateFunction(int[] nums) {
        int res = 0;
        int[] before = new int[nums.length];
        int value = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                before[i] = nums[i];
            }else {
                before[i] = before[i - 1] + nums[i];
            }
            value += nums[i] * i;
        }

        int[] after = new int[nums.length];
        for(int i = nums.length - 2;i >= 0; i--) {
            after[i] = after[i + 1] + nums[i + 1];
        }
        res = value;

        for(int i = nums.length - 1; i >= 0; i--) {
            int pre = i - 1>=0 ? before[i - 1] : 0;
            value = pre + value - nums[i] * (nums.length - 1) + after[i];
            res = Math.max(res, value);
        }

        return res;
    }
}
