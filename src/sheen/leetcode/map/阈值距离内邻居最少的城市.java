package sheen.leetcode.map;

import java.util.Arrays;

/**
 * @Classname 阈值距离内邻居最少的城市
 * @Date 2023/11/14 00:09
 * @Created by sheen
 * @Description TODO
 */
public class 阈值距离内邻居最少的城市 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] map = new int[n][n];
        for(int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE / 2);
            map[i][i] = 0;
        }

        for(int i = 0; i < edges.length; i++) {
            map[edges[i][0]][edges[i][1]] = edges[i][2];
            map[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j++) {
                for(int z = 0; z < n; z++) {
                    map[j][z] = Math.min(map[j][z], map[j][i] + map[i][z]);
                }
            }
        }

        int res = -1;
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if (i != j && map[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (minCount >= count) {
                res = i;
                minCount = count;
            }
        }
        return res;
    }
}
