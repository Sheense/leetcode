package com.company.GeminiNeedle;

import com.company.util.ArrayUtils;

public class 颜色分类 {

    public static void main(String[] args) {
        颜色分类 s = new 颜色分类();
        int nums[] = {2,0,2,1,1,1,2,0,1,1,0,2,1,0,2};
        s.sortColors(nums);
        ArrayUtils.print(nums);
    }

    public void sortColors(int[] nums) {
        int i0 = -1;
        int i1 = 0;
        int i2 = nums.length;
        while(i1<i2) {
            if(nums[i1]==0) {
                ++i0;
                if(i0==i1) i1++;
                else {
                    nums[i1] = nums[i0];
                    nums[i0] = 0;
                }
            } else if(nums[i1] == 2) {
                i2--;
                nums[i1] = nums[i2];
                nums[i2] = 2;
            } else {
                i1++;
            }
        }
    }
}
