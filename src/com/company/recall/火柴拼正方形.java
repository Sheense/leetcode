package com.company.recall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Classname 火柴拼正方形
 * @Date 2022/6/1 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 火柴拼正方形 {
    public static void main(String[] args) {
        火柴拼正方形 s = new 火柴拼正方形();
        System.out.println(s.makesquare(new int[]{13,11,1,8,6,7,8,8,6,7,8,9,8}));
    }
    public boolean makesquare(int[] matchsticks) {
        long sum = 0;
        long max = 0;
        for(int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
            max = Math.max(max, matchsticks[i]);

        }

        if(sum % 4 != 0) {
            return false;
        }

        long len = sum / 4;
        if(len < max) {
            return false;
        }

        Arrays.sort(matchsticks);
        int[] edge = new int[4];

        return dfs(matchsticks.length - 1, matchsticks, len, edge);
    }

    public boolean dfs(int index,int[] matchsticks, long len, int[] edge) {
        if(index == -1) {
            return true;
        }


        for(int i = 0; i < edge.length; i++) {
            edge[i] += matchsticks[index];
            if(edge[i] <= len && dfs(index - 1, matchsticks, len, edge)) {
                return true;
            }

            edge[i] -= matchsticks[index];
        }

        return false;
    }
}
