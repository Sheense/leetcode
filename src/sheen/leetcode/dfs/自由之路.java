package sheen.leetcode.dfs;

import java.util.*;

/**
 * @Classname 自由之路
 * @Date 2024/1/29 00:07
 * @Created by sheen
 * @Description TODO
 */
public class 自由之路 {
    public static void main(String[] args) {
        自由之路 s = new 自由之路();
        System.out.println(s.findRotateSteps("godding", "gd"));
    }
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m][n];

        List<Integer>[] pos = new List[26];
        for(int i = 0; i < 26; i++) {
            pos[i] = new ArrayList();
        }

        for(int i = 0; i < ring.length(); i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 100000);
        }

        for(int j : pos[key.charAt(0) - 'a']) {
            dp[0][j] = Math.min(j, n - j) + 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j : pos[key.charAt(i) - 'a']) {
                for(int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) +  1);
                }
            }
        }

        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }


}
