package com.company.dp;

import com.company.util.ArrayUtils;

import java.lang.reflect.Array;

public class 加油站 {
    public static void main(String[] args) {
        加油站 s = new 加油站();
        System.out.println(s.canCompleteCircuit(new int[]{4,5,3,1,4},new int[]{5,4,3,4,2}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int dp[] = new int[gas.length];
        for(int i=0;i<gas.length;i++) {
            int num = gas[i];
            int lu = cost[i%gas.length];
            dp[i] = num - lu;
        }


        for(int i=0;i<gas.length;i++) {
            if(dp[i]<0) continue;
            int j = i+1;
            int all = dp[i];
            while(j%gas.length!=i) {
                all += dp[j%gas.length];
                j++;
                if(all<=0) break;
            }
            if(j%gas.length==i&&all>=0) {
                return i;
            }
        }
        return -1;
    }
}
