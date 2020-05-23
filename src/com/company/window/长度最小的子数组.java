package com.company.window;

public class 长度最小的子数组 {

    public static void main(String[] args) {
        长度最小的子数组 s= new 长度最小的子数组();
        System.out.println(s.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int all = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>s) return 1;
            nums[i] = all + nums[i];
            all = nums[i];
            if(all>s) {
                int target = all-s;
                int start = 0;
                int end = i-1;
                while(start<=end) {
                    int mid = (start+end)/2;
                    if(nums[mid]>target) {
                        end = mid-1;
                    }else if(nums[mid]<target) {
                        start = mid+1;
                    }else {
                        end = mid;
                        break;
                    }
                }
                if(min>i-end) {
                    min = i-end;

                }
            }else if(all==s) {
                if(min>i+1) {
                    min = i+1;
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
