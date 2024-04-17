package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 统计参与通信的服务器
 * @Date 2023/8/24 00:06
 * @Created by sheen
 * @Description TODO
 */
public class 统计参与通信的服务器 {
    public int countServers(int[][] grid) {
        List<int[]> row = new ArrayList<>();
        int all = 0;
        for(int i = 0; i < grid.length; i++) {
            int count = 0;
            int item[] = new int[2];
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    count++;
                    item = new int[]{i, j};
                    all++;
                }

            }
            if(count == 1) {
                row.add(item);
            }
        }
        int yu = 0;
        for(int r[] : row) {
            int x = r[0];
            int y = r[1];
            int count = 0;
            for(int i = 0; i < grid.length; i++) {
                if(i != x && grid[i][y] == 1) {
                    count++;
                }
            }
            if(count == 0) {
                yu++;
            }
        }
        return all - yu;
    }
}
