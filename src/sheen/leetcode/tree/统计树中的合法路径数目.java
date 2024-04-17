package sheen.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 统计树中的合法路径数目
 * @Date 2024/2/27 00:40
 * @Created by sheen
 * @Description TODO
 */
public class 统计树中的合法路径数目 {
    public static void main(String[] args) {
        统计树中的合法路径数目 s = new 统计树中的合法路径数目();
        System.out.println(s.countPaths(5, new int[][] {{1,2},{1,3},{2,4},{2,5}}));
    }
    private static boolean[] isPrime = new boolean[100001];
    static {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    public long countPaths(int n, int[][] edges) {
        List<Integer>[] G = new List[n + 1];
        for(int i = 0; i < G.length; i++) {
            G[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            G[edge[0]].add(edge[1]);
            G[edge[1]].add(edge[0]);
        }

        List<Integer> seen = new ArrayList<>();
        long[] count = new long[n + 1];
        long res = 0;
        for(int i = 1; i <= n; i++) {
            if(isPrime[i]) {
                long cur = 0;
               for(int j : G[i]) {
                   if(isPrime[j]) {
                       continue;
                   }

                   if(count[j] == 0) {
                       seen.clear();
                       dfs(G, j, 0, seen);
                       for(int point : seen) {
                           count[point] = seen.size();
                       }
                   }
                   res += cur * count[j];
                   cur += count[j];
               }
               res += cur;
            }
        }
        return res;
    }

    public void dfs(List<Integer>[] G, int now, int pre, List<Integer> seen) {
        seen.add(now);
        for(int j : G[now]) {
            if(pre != j && !isPrime[j]) {
                dfs(G, j, now, seen);
            }
        }
    }
}
