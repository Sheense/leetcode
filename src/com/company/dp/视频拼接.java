package com.company.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 视频拼接 {
    public static void main(String[] args) {
        视频拼接 s = new 视频拼接();
        System.out.println(s.videoStitching(new int[][]
                {{17,18},{25,26},{16,21},{3,3},{19,23},{1,5},{0,2},{9,20},{5,17},{8,10}},15));
    }
    public int videoStitching(int[][] clips, int T) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<clips.length;i++) {
            int key = clips[i][1];
            if (key>T) key = T;
            if(clips[i][0]>T) continue;
            map.computeIfAbsent(key, x -> new ArrayList<>()).add(clips[i][0]);
        }
        int [] dp = new int[T+1];
        for(int i=0;i<=T;i++) {
            if(!map.containsKey(i)) {
                dp[i] = -1;
                continue;
            }
            List<Integer> list = map.get(i);
            for(int j:list) {
                if(j==0) {
                    dp[i] = 1;
                    break;
                }
                if(j==i&&j-1>=0&&dp[j-1]>0) dp[i] = dp[i]==0?dp[j-1]+1:Math.min(dp[j-1]+1, dp[i]);
                for(int z = j;z<i&&z<T;z++) {
                    if(dp[z]!=-1) {
                        if(dp[i]==0) dp[i] = dp[z] + 1;
                        else dp[i] = Math.min(dp[i], dp[z] + 1);
                    }
                }
            }
            if(dp[i]==0)dp[i] = -1;
        }
        return dp[T];
    }
}
