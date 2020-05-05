package com.company.greedyAlgorithm;

public class 最低票价 {

    public static void main(String[] args) {
        最低票价 s = new 最低票价();
        System.out.println(s.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int i = days.length-1;
        for(int j=dp.length-1;j>=1;j--) {
            if(j==dp.length-1){
                if(days[i]==j) {
                    dp[j] = costs[0];
                    i--;
                }
                continue;
            }
            if(i!=-1&&days[i]==j) {
                int day1 = costs[0]+dp[j+1];
                int day7 = j+7>=dp.length?Math.min(dp[j+1]+costs[0],costs[1]) : dp[j+7] + costs[1];
                int day30 = j+30>=dp.length?Math.min(dp[j+1]+costs[0],costs[2]) : dp[j+30] + costs[2];
                int min = Math.min(day1, Math.min(day7,day30));
                dp[j] = min;
                i--;
            }else{
                dp[j] = dp[j+1];
            }
        }
        return dp[1];
    }
}
