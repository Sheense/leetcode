package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 可以攻击国王的皇后
 * @Date 2023/9/14 00:59
 * @Created by sheen
 * @Description TODO
 */
public class 可以攻击国王的皇后 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] mat = new int[][]{{-1, -1}, {1, 1}, {-1, 1}, {1, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < queens.length; i++) {
            set.add(queens[i][0] * 8 + queens[i][1]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int arr[] : mat) {
            int x = king[0];
            int y = king[1];
            while (x + arr[0] >= 0 && x + arr[0] < 8 && y + arr[1] >= 0 && y + arr[1] < 8) {
                int v = (x + arr[0]) * 8 + y + arr[1];
                if(set.contains(v)) {
                    res.add(Arrays.asList(x + arr[0], y + arr[1]));
                    break;
                }
                x = x + arr[0];
                y = y + arr[1];
            }
        }

        return res;
    }
}
