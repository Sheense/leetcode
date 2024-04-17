package sheen.leetcode.dfs;

import java.util.*;

/**
 * @Classname 统计所有可行路径
 * @Date 2023/5/6 11:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计所有可行路径 {
    public static void main(String[] args) {
        统计所有可行路径 s = new 统计所有可行路径();
        System.out.println(s.countRoutes(new int[]{2,1,5}, 0, 0, 3));
    }

    private static int MOD = (int)Math.pow(10, 9) + 7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0; i < locations.length; i++) {
            for(int j = 0; j < locations.length; j++) {
                if(i != j) {
                    map.computeIfAbsent(i, x -> new ArrayList<>()).add(new int[]{j, Math.abs(locations[i] - locations[j])});
                }
            }
            Collections.sort(map.get(i), (x, y) -> x[1] - y[1]);
        }
        int res = recall(new HashMap<>(), start, fuel, finish, map);
        if(start == finish) {
            res ++;
        }
        return res;
    }

    public int recall(Map<String, Integer> map, int point, int fuel, int finish, Map<Integer, List<int[]>> points) {
        String key = point + "#" + fuel;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int res = 0;
        for(int[] item : points.get(point)) {
            if(item[1] <= fuel) {
                int next = item[0];
                if(next == finish) {
                    res++;
                    res %= MOD;
                }
                res += recall(map, next, fuel - item[1], finish, points);
                res %= MOD;
            }
        }
        map.put(key, res);
        return res;
    }
}
