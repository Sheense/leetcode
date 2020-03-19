package com.company.GeminiNeedle;

public class 盛最多水的容器 {
    public static void main(String[] args) {
       盛最多水的容器 s = new 盛最多水的容器();
        System.out.println(s.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while(i!=j) {
            int s = (j-i) * Math.min(height[i], height[j]);
            if(max<s) max = s;
            if(height[i]>height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
