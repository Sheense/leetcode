package sheen.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 可互换矩形的组数
 * @Date 2021/9/12 10:39 上午
 * @Created by sheen
 * @Description TODO
 */
public class 可互换矩形的组数 {
    public static void main(String[] args) {
        可互换矩形的组数 s = new 可互换矩形的组数();
        System.out.println(s.interchangeableRectangles(new int[][]{{4,8},{3,6},{10,20},{15,30}}));
    }
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Integer, Map<Integer, Long>> map = new HashMap<>();

        for(int i = 0; i < rectangles.length; i++) {
            int mod = mod(Math.max(rectangles[i][0], rectangles[i][1]), Math.min(rectangles[i][0], rectangles[i][1]));
            int a = rectangles[i][0] / mod;
            int b = rectangles[i][1] / mod;
            Map<Integer, Long> m = map.computeIfAbsent(a, x -> new HashMap<>());
            m.put(b, m.getOrDefault(b, 0L) + 1);
        }
        long res = 0;
        for(int key1 : map.keySet()) {
            Map<Integer, Long> m = map.get(key1);
            for(int key2 : m.keySet()) {
                long count = m.get(key2);
                res += (count * (count - 1)) / 2;
            }
        }
        return res;
    }

    public int mod(int max, int min) {
        int b = max % min;
        if(b == 0) {
            return min;
        }
        return mod(min, b);
    }
}
