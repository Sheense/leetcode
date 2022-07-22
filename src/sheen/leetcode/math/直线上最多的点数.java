package sheen.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class 直线上最多的点数 {

    public static void main(String[] args) {
        直线上最多的点数 s = new 直线上最多的点数();
        System.out.println(s.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
    }
    public int maxPoints(int[][] points) {
        int max = 1;
        for(int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++) {
                if(j != i) {
                    int y = points[j][1] - points[i][1];
                    int x = points[j][0] - points[i][0];
                    if (x != 0 && y != 0) {
                        int gcd = 1;
                        if (x >= y) {
                            gcd = gcd(x, y);
                        }else {
                            gcd = gcd(y, x);
                        }
                        x /= gcd;
                        y /= gcd;
                        if (x < 0) {
                            x = -x;
                            y = -y;
                        }
                        String key = x + "&" + y;
                        map.put(key, map.getOrDefault(key, 0) + 1);
                    } else {
                        String key = "";
                        if(x == 0) {
                            key = "0&";
                        }else {
                            key = "&0";
                        }
                        map.put(key, map.getOrDefault(key, 0) + 1);
                    }
                }
            }
            for (int value : map.values()) {
                max = Math.max(max, value + 1);
            }
        }
        return max;
    }

    public int gcd(int a, int b) {
        int c = a % b;
        if(c == 0) return b;
        return gcd(b, c);
    }
}
