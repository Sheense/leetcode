package com.company.array;

/**
 * @Classname 买票需要的时间
 * @Date 2021/11/14 11:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 买票需要的时间 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        for(int i = 0 ; i <= k; i++) {
            res = res + (tickets[i] >= tickets[k] ? tickets[k] : tickets[i]);
        }

        for(int i = k + 1; i < tickets.length; i++) {
            res = res + (tickets[i] >= tickets[k] - 1 ? tickets[k] - 1 : tickets[i]);
        }
        return res;
    }
}
