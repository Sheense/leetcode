package sheen.leetcode.array;

import java.util.*;

/**
 * @Classname 两点之间不包含任何点的最宽垂直区域
 * @Date 2023/3/30 12:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 两点之间不包含任何点的最宽垂直区域 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < points.length; i++) {
            set.add(points[i][0]);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int res = 0;
        for(int i = 0 ; i < list.size() - 1; i++) {
            res = Math.max(res, list.get(i + 1) - list.get(i));
        }
        return res;
    }
}
