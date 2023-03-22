package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 图中最大星和
 * @Date 2022/12/10 11:15 下午
 * @Created by sheen
 * @Description TODO
 */
public class 图中最大星和 {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x -> new ArrayList<>()).add(vals[edges[i][1]]);
            map.computeIfAbsent(edges[i][1], x -> new ArrayList<>()).add(vals[edges[i][0]]);
        }

        int res = vals[0];

        for(int key = 0; key < vals.length; key++) {
            List<Integer> list = map.get(key);
            int item = vals[key];
            if(list != null) {
                Collections.sort(list, (x, y) -> y - x);
                for(int i = 0; i < k && i < list.size(); i++) {
                    if(list.get(i) > 0) {
                        item += list.get(i);
                    }else {
                        break;
                    }
                }
            }
            res = Math.max(res, item);
        }

        return res;


    }
}
