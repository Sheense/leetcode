package com.company.greedyAlgorithm;

import com.company.util.ArrayUtils;

public class 分发糖果 {

    public static void main(String[] args) {
        分发糖果 s = new 分发糖果();
        System.out.println(s.candy(new int[]{1,2,3,1,0}));
    }

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length==0) return 0;
        if(ratings.length==1) return 1;
        if(ratings.length==2) return ratings[0]==ratings[1] ? 2 : 3;
        int min = 1;
        int [] dp = new int[ratings.length];
        int sum = 0;
        if(ratings[0]==ratings[1]) {
            dp[0] = 1;
            dp[1] = 1;
            sum = 2;
        } else if (ratings[0]>ratings[1]){
            dp[0] = 2;
            dp[1] = 1;
            sum = 3;
        } else {
            dp[0] = 1;
            dp[1] = 2;
            sum = 3;
        }
        for(int i=2;i<ratings.length;i++) {
            if(ratings[i-1]>=ratings[i]) {
                if(dp[i-1] == 1 && ratings[i-1]!=ratings[i]) {
                    dp[i-1] ++;
                    sum++;
                    for(int j= i-2;j>=0;j--) {
                        if(ratings[j]<=ratings[j+1]) break;
                        else {
                            if (dp[j] > dp [j+1]) {
                                break;
                            }
                            dp[j] ++;
                            sum ++;
                        }
                    }
                }
                dp[i] = 1;
            } else{
                dp[i] = dp[i-1]+1;
            }
            sum += dp[i];
        }
        ArrayUtils.print(dp);
        return sum;
    }
}
