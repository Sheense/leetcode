package com.company.dp;

public class 乘积为正数的最长子数组长度 {
    public static void main(String[] args) {
        乘积为正数的最长子数组长度 s = new 乘积为正数的最长子数组长度();
        System.out.println(s.getMaxLen(new int[]{-209,175,364,0,0,-378,-185,19,364,379,-397,0,53,-68,-328,-196,0,232,-200,-174,191,395,153,176,90,239,-368,-34,109,-324,-54,-34,57,-216,-357,108,32,-252,-347,-349,97,-402,-234,-43,219,-337,-279,305,315,-241,-327,133,305,-359,124,76,224,-384,241,-377,44,106,419,165,-85,0,9,-341,350,327,239,-424,355,-64,4,-294,-341,394,-265,71,88,309,-289,-167,-269,-192,-118,-353}));
    }
    public int getMaxLen(int[] nums) {
        System.out.println(nums.length);
        int res =0 ;
        int len1 = 0;
        int len2 = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) {
                len1++;
                if(len2 != 0) {
                    len2++;
                }
                if(res<len1) res =len1;
            }else if(nums[i]<0){
                int tempLen = len1;
                if(len2!=0) {
                    len1 = len2+1;
                }else {
                    len1 = 0;
                }
                if(res<len1) res = len1;
                if(tempLen!=0) {
                    len2 = tempLen + 1;
                }else {
                    len2=1;
                }
            }else {
                len1 = 0;
                len2 = 0;
            }
        }
        return res;
    }
}
