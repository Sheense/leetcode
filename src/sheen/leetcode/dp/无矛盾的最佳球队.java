package sheen.leetcode.dp;

import java.util.Arrays;

public class 无矛盾的最佳球队 {
    public static void main(String[] args) {
        无矛盾的最佳球队 s = new 无矛盾的最佳球队();
        System.out.println(s.bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        sort(0, scores.length-1, scores,ages);
        sort(scores, ages);
        int[]  dp = new int[scores.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<scores.length;i++) {
            dp[i] = scores[i];
            for(int j = i-1;j>=0;j--) {
                if(ages[j]<ages[i]&&scores[j]<=scores[i]||(ages[i] == ages[j])) {
                    dp[i] = Math.max(dp[i], dp[j]+scores[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public void sort(int[] score, int[] ages) {
        int i = 0;
        while(i<score.length) {
            int j = i+1;
            while(j<score.length&&ages[i]==ages[j]) j++;
            Arrays.sort(score, i, j);
            i = j;
        }
    }

    public void sort(int start, int end, int[] score, int[] ages) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int s = score[start];
        int a = ages[start];
        while(left<right) {
            while(left<right&&a<=ages[right]) right--;
            ages[left] = ages[right];
            score[left] = score[right];
            while(left<right&&a>=ages[left]) left++;
            ages[right] = ages[left];
            score[right] = score[left];
        }
        score[left] = s;
        ages[left] = a;
        sort(start, left-1, score, ages);
        sort(left+1,end,score,ages);
    }
}
