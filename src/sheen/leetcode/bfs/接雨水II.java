package sheen.leetcode.bfs;

import java.util.PriorityQueue;

public class 接雨水II {
    public int trapRainWater(int[][] heightMap) {
        boolean[][] map = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> heightMap[o1[0]][o1[1]] - heightMap[o2[0]][o2[1]]);
        for(int i=0;i<heightMap[0].length;i++) {
            queue.offer(new int[]{0, i});
            map[0][i] = true;
            queue.offer(new int[]{heightMap.length-1, i});
            map[heightMap.length-1][i] = true;
        }
        for (int i=1;i<heightMap.length-1;i++) {
            queue.offer(new int[]{i, 0});
            map[i][0] = true;
            queue.offer(new int[]{i, heightMap[0].length-1});
            map[i][heightMap[0].length-1] = true;
        }
        int res = 0;
        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int x = pair[0];
            int y = pair[1];
            int now = heightMap[x][y];
            if(x-1 >=0 && !map[x-1][y]) {
                if(now > heightMap[x-1][y]) {
                    res += (now - heightMap[x-1][y]);
                    heightMap[x-1][y] = now;
                }
                queue.offer(new int[]{x-1, y});
                map[x-1][y] = true;
            }
            if (x + 1 < map.length && !map[x + 1][y]) {
                if(now > heightMap[x+1][y]) {
                    res += (now - heightMap[x+1][y]);
                    heightMap[x+1][y] = now;
                }
                queue.offer(new int[]{x+1, y});
                map[x+1][y] = true;
            }
            if (y - 1 >= 0 && !map[x][y-1]) {
                if(now > heightMap[x][y-1]) {
                    res += (now - heightMap[x][y-1]);
                    heightMap[x][y-1] = now;
                }
                queue.offer(new int[]{x, y-1});
                map[x][y-1] = true;
            }
            if (y + 1 < map[0].length && !map[x][y+1]) {
                if(now > heightMap[x][y+1]) {
                    res += (now - heightMap[x][y+1]);
                    heightMap[x][y+1] = now;
                }
                queue.offer(new int[]{x, y+1});
                map[x][y+1] = true;
            }

        }
        return res;
    }
}
