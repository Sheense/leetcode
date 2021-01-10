package com.company.math;

public class 接雨水 {

    public static void main(String[] args) {
        接雨水 s = new 接雨水();
        System.out.println(s.trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));
    }

    public int trap(int[] height) {
        if(height.length==0) return 0;
        int all = 0;
        int get = 0;
        int index = 0;
        boolean [] judge = new boolean[height.length];
        for(int i=1;i<height.length;i++) {
            if(height[index]<=height[i]) {
                judge[index] = true;
                judge[i] = true;
                all+=get;
                get = 0;
                index = i;
            }else  {
                get += height[index]-height[i];
            }
        }
        index = height.length-1;
        get = 0;
        for(int i=height.length-2;i>=0;i--)
        {
            if(height[index]<=height[i]) {
                if(!(judge[i]&&judge[index])) {
                    all+=get;
                }
                get = 0;
                index = i;
            } else  {
                get += height[index]-height[i];
            }
        }
        return all;
    }
}
