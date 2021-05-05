package com.company.dp;

import java.util.Arrays;

//最长上升子序列，nlogn解法
public class 马戏团人塔 {

    public static void main(String[] args) {
        马戏团人塔 s = new 马戏团人塔 ();
        System.out.println(s.bestSeqAtIndex(new int[]{65,70,56,75,60,68}, new int[]{100,150,90,190,95,110}));
    }
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][] persons = new int[height.length][2];
        for(int i=0;i<height.length;i++) {
            persons[i] = new int[]{height[i], weight[i]};
        }
        Arrays.sort(persons, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int[] dp = new int[height.length];
        dp[0] = persons[0][1];
        int end = 0;
        for(int i=1;i<persons.length;i++) {
            if(persons[i][1] > dp[end]) {
                dp[++end] = persons[i][1];
            }else {
                int left = 0;
                int right = end;
                while (left<=right) {
                    int mid = (left + right) / 2;
                    if(dp[mid]>=persons[i][1]) {
                        right = mid - 1;
                    }else {
                        left = left + 1;
                    }
                }
                dp[left] = persons[i][1];
            }
        }
        return end + 1;
    }

}
