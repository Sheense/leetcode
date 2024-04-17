package sheen.leetcode.tree;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 互质树
 * @Date 2024/4/11 00:11
 * @Created by sheen
 * @Description TODO
 */
public class 互质树 {
    public static void main(String[] args) {
        互质树 s = new 互质树();
        ArrayUtils.print(s.getCoprimes(new int[]{2,3,3,2}, new int[][]{{0,1},{1,2},{1,3}}));
    }
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int dep[] = new int[nums.length];
        Arrays.fill(dep, -1);
        List<Integer>[] gcd = new List[51];
        List<Integer>[] router = new List[51];
        for(int i = 1; i <= 50; i++) {
            gcd[i] = new ArrayList<>();
            router[i] = new ArrayList<>();
            for(int j = 1; j <= 50; j++) {
                if(gcd(Math.max(i, j), Math.min(i, j)) == 1) {
                    gcd[i].add(j);
                }
            }
        }

        List<Integer>[] map = new List[nums.length];
        for(int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        dfs(nums,  router, gcd, ans, 0, map, dep, 0);
        return ans;
    }

    public void dfs(int[] nums, List<Integer>[] router, List<Integer>[] gcd, int[] ans, int now, List<Integer>[] map, int dep[], int depth) {
        dep[now] = depth;

        for(int item : gcd[nums[now]]) {
            if(!router[item].isEmpty()) {
                int v = router[item].get(router[item].size() - 1);
                if(ans[now] == -1 || dep[ans[now]] < dep[v]) {
                    ans[now] = v;
                }
            }
        }

        router[nums[now]].add(now);

        for(int next : map[now]) {
            if(dep[next] == -1) {
                dfs(nums, router, gcd, ans, next, map, dep, depth + 1);
            }
        }

        router[nums[now]].remove(router[nums[now]].size() - 1);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
