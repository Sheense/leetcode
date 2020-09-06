package com.company.greedyAlgorithm;

public class 避免重复字母的最小删除成本 {
    public static void main(String[] args) {
        避免重复字母的最小删除成本 s = new 避免重复字母的最小删除成本();
        System.out.println(s.minCost("aabaa", new int[]{1,2,3,4,1}));
    }
    public int minCost(String s, int[] cost) {
        int res = 0;
        int i = 0;
        while(i<s.length()) {
            int time = 1;
            int all = cost[i];
            int max = cost[i];
            while(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)) {
                i++;
                all+=cost[i];
                max = Math.max(max, cost[i]);
                time++;
            }
            if(time>1) {
                res += (all-max);
            }
            i++;
        }
        return res;
    }
}
