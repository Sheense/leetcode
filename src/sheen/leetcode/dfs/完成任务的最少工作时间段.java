package sheen.leetcode.dfs;

import java.util.*;

/**
 * @Classname 完成任务的最少工作时间段
 * @Date 2021/8/29 10:48 上午
 * @Created by sheen
 * @Description TODO
 */
public class 完成任务的最少工作时间段 {
    public static void main(String[] args) {
        完成任务的最少工作时间段 s = new 完成任务的最少工作时间段();
        System.out.println(s.minSessions(new int[]{7,4,3,8,10}, 12));
    }

    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int N = 1 << n;
        int[] dp = new int[N];
        int[] sum = new int[N];
        Arrays.fill(dp, 1000);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < n; j++) {
                if(((1 << j) & i) != 0) {
                    sum[i] += tasks[j];
                }
            }
            if(sum[i] <= sessionTime) {
                dp[i] = 1;
            }
        }

        for(int i = 0; i < N; i++) {
            //遍历子集
            for(int j = i; j > 0; j = (j-1) & i) {
                if(sum[j] <= sessionTime) {
                    dp[i] = Math.min(dp[i], dp[i ^ j] + 1);
                }
            }
        }
        return dp[N - 1];
    }
}
