package sheen.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 重新规划路线
 * @Date 2023/12/7 00:39
 * @Created by sheen
 * @Description TODO
 */
public class 重新规划路线 {

    public int minReorder(int n, int[][] connections) {
        List<int[]>[] list = new List[n];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            list[from].add(new int[]{to, 1});
            list[to].add(new int[]{from, 0});
        }
        return dfs(0, -1, list);
    }

    public int dfs(int now, int pre, List<int[]>[] list) {
        int res = 0;
        for(int[] item : list[now]) {
            if(item[0] == pre) {
                continue;
            }

            res += item[1] + dfs(item[0], now, list);
        }

        return res;
    }
}
