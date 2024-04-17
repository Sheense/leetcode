package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 回旋镖的数量
 * @Date 2024/1/8 00:07
 * @Created by sheen
 * @Description TODO
 */
public class 回旋镖的数量 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for(int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++) {
                if(i != j) {
                    double key = Math.pow(points[j][0] - points[i][0], 2) + Math.pow(points[j][1] - points[i][1], 2);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }

            for(int v : map.values()) {
                res += v * (v - 1);
            }
        }
        return res;
    }
}
