package com.company.sort;

import java.util.Arrays;

public class 雪糕的最大数量 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for(int i=0;i<costs.length;i++) {
            if(coins - costs[i] >= 0) {
                res ++;
                coins -= costs[i];
            }else {
                return res;
            }
        }
        return res;
    }
}
