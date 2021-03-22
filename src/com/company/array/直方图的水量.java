package com.company.array;

public class 直方图的水量 {
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
