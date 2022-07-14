package com.company.array;

import java.util.Stack;

public class 直方图的水量 {
    public static void main(String[] args) {
        直方图的水量  s = new 直方图的水量();
        //4,2,0,3,2,4,3,4
        //[9,6,8,8,5,6,3]
        //5,2,1,2,1,5
        System.out.println(s.trap(new int[]{5,2,1,2,1,5}));
    }

    public int trap(int[] height) {
        if (height.length==0) return 0;
        int res = 0;
        int left = 0;
        int now = 0;
        for (int i=1;i<height.length;i++) {
            if (height[left] <= height[i]) {
                res += now;
                left = i;
                now = 0;
            }else {
                now += (height[left] - height[i]);
            }
        }
        now = 0;
        int right = height.length-1;
        for(int i=height.length-2;i>=left;i--) {
            if (height[right]<=height[i]) {
                res += now;
                right = i;
                now = 0;
            } else{
                now += (height[right] - height[i]);
            }
        }
        return res;
    }
}
