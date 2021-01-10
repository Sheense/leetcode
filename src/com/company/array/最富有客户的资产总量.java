package com.company.array;

public class 最富有客户的资产总量 {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for(int i=0;i<accounts.length;i++) {
            int item = 0;
            for(int j=0;j<accounts[i].length;j++) {
                item += accounts[i][j];
            }
            res = Math.max(item, res);
        }
        return res;
    }
}
