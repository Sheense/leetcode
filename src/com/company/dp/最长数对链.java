package com.company.dp;

import com.company.util.ArratyUtils;

public class 最长数对链 {
    public static void main(String[] args) {

        最长数对链 s = new 最长数对链();
        int[][] array ={{9,10},{-4,9},{-5,6},{-5,9},{8,9}};


        System.out.println(s.findLongestChain(array));

        s.sort(0,array.length-1,array);
        ArratyUtils.print2(array);
    }

    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length==0) return 0;
        sort(0, pairs.length-1, pairs);
        int [] dp = new int[pairs.length];
        int res = 0;
        for(int i=pairs.length-1;i>=0;i--) {
            int max = 0;
            for(int j= i+1; j<pairs.length;j++) {
                if(pairs[j][0]>pairs[i][1]&&max<dp[j]) max = dp[j];
            }
            dp[i] = max + 1;
            if(dp[i]>res) res = dp[i];
        }
        return res;
    }
    public void sort(int start, int end, int pair[][]) {
        if(start>=end) return;
        int left = start;
        int right = end;
        while(left<right) {
            while(left!=right&&pair[left][0]<=pair[right][0]) {
                right--;
            }
            if(left==right) break;
            swap(left,right,pair);
            while(left!=right&&pair[left][0]<=pair[right][0]) {
                left++;
            }
            if(left==right) break;
            swap(left,right,pair);
        }
        sort(start,left-1, pair);
        sort(left+1, end, pair);
    }
    public void swap(int a, int b, int pair[][]) {
        int [] item = pair[a];
        pair[a] = pair[b];
        pair[b] = item;
    }
}
