package sheen.leetcode.bfs;

import java.util.*;

/**
 * @Classname 获取所有钥匙的最短路径
 * @Date 2022/11/10 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 获取所有钥匙的最短路径 {

    public static void main(String[] args) {
        获取所有钥匙的最短路径 s = new 获取所有钥匙的最短路径();
        String str[] = new String[]{
                "..#....##.",
                "....d.#.D#",
                "#...#.c...",
                "..##.#..a.",
                "...#....##",
                "#....b....",
                ".#..#.....",
                "..........",
                ".#..##..A.",
                ".B..C.#..@"};
        System.out.println(s.shortestPathAllKeys(str));


    }


    private static int[][] WALK = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestPathAllKeys(String[] grid) {
        int startX = 0;
        int startY = 0;
        int keys = 0;
        //找出钥匙数量和起点
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length(); j++) {
                if(grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'z') {
                    keys ++;
                }else if(grid[i].charAt(j) == '@') {
                    startX = i;
                    startY = j;
                }
            }
        }
        boolean[][][] check = new boolean[grid.length][grid[0].length()][(1 << keys)];
        //身上钥匙出口状态吗
        int allKeys = (int)Math.pow(2, keys) - 1;
        int rows = grid.length;
        int cols = grid[0].length();
        int startV = startX * cols + startY;
        check[startX][startY][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startV, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int[] item = queue.poll();
                int v = item[0];
                int x = v / cols;
                int y = v % cols;
                int k = item[1];
                for(int[] w : WALK) {
                    int newX = x + w[0];
                    int newY = y + w[1];
                    if(newY >= 0 && newY < cols && newX >= 0 && newX < rows) {
                        if(grid[newX].charAt(newY) == '#') {
                            continue;
                        }
                        int newV = newX * cols + newY;
                        int newK = k;
                        if(grid[newX].charAt(newY) >= 'a' && grid[newX].charAt(newY) <= 'z') {
                            int index = grid[newX].charAt(newY) - 'a';
                            newK |= (1 << index);
                            if(newK == allKeys) {
                                return res + 1;
                            }
                        }else if(grid[newX].charAt(newY) >= 'A' && grid[newX].charAt(newY) <= 'Z') {
                            int index = grid[newX].charAt(newY) - 'A';
                            if(((1 << index) | k) != k) {
                                continue;
                            }
                        }
                        if(!check[newX][newY][newK]) {
                            check[newX][newY][newK] = true;
                            queue.offer(new int[]{newV, newK});
                        }
                    }
                }
            }
            res ++;
        }

        return -1;
    }
}
