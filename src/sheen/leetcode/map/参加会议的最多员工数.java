package sheen.leetcode.map;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 参加会议的最多员工数
 * @Date 2023/11/1 00:32
 * @Created by sheen
 * @Description TODO
 */
public class 参加会议的最多员工数 {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        boolean[] used = new boolean[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] du = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            du[favorite[i]]++;
        }

        for(int i = 0; i < n; i++) {
            if (du[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size--!= 0) {
                int index = queue.poll();
                used[index] = true;
                int next = favorite[index];
                du[next]--;
                dp[next] = Math.max(dp[index] + 1, dp[next]);
                if(du[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        int rings = 0;
        int total = 0;
        for(int i = 0; i < n; i++) {
            if (!used[i]) {
                if(favorite[favorite[i]] == i) {
                    total += dp[i] + dp[favorite[i]];
                    used[i] = true;
                    used[favorite[i]] = true;
                }else {
                    int count = 0;
                    int j = i;
                    while (!used[j]) {
                        used[j] = true;
                        count++;
                        j = favorite[j];
                    }
                    rings = Math.max(rings, count);
                }
            }
        }

        return Math.max(rings, total);
    }
}
