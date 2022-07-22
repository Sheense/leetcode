package sheen.leetcode.sort;

import sheen.leetcode.util.ArrayUtils;

public class 部分排序 {
    public static void main(String[] args) {
        部分排序 s = new 部分排序();
        ArrayUtils.print(s.subSort(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19}));
    }

    public int[] subSort(int[] array) {
        if(array.length==0||array.length==1) return new int[]{-1,-1};
        int[][] dp = new int[array.length][2];
        for(int i=0;i< array.length;i++) {
            if(i==0) {
                dp[i][0] = array[0];
                dp[array.length-1-i][1] = array[array.length-1-i];
            }else {
                dp[i][0] = Math.max(dp[i-1][0], array[i]);
                dp[array.length-1-i][1] = Math.min(dp[array.length-i][1], array[array.length-1-i]);
            }
        }
        int start = 0;
        while (start<array.length-1&&array[start]<=dp[start+1][1]) {
            start++;
        }
        if(start == array.length-1) {
            return new int[]{-1,-1};
        }
        int end = array.length-1;
        while (end>0&&array[end]>=dp[end-1][0]) {
            end--;
        }
        return new int[]{start, end};
    }
}
