package com.company.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 完美矩形
 * @Date 2021/11/16 12:43 上午
 * @Created by sheen
 * @Description TODO
 */
public class 完美矩形 {
    public static void main(String[] args) {
        完美矩形 s= new 完美矩形();
        System.out.println(s.isRectangleCover(new int[][]{{0,0,3,3},{1,1,2,2},{1,1,2,2}}));
    }
    public boolean isRectangleCover(int[][] rectangles) {
        Map<Point, Integer> map = new HashMap<>();
        int area = 0;
        int mini = rectangles[0][0];
        int minj = rectangles[0][1];
        int maxi = rectangles[0][2];
        int maxj = rectangles[0][3];
        for(int i = 0 ; i < rectangles.length; i++) {
            area += Math.abs(rectangles[i][0] - rectangles[i][2]) * Math.abs(rectangles[i][1] - rectangles[i][3]);
            Point point1 = new Point(rectangles[i][0], rectangles[i][1]);
            Point point2 = new Point(rectangles[i][2], rectangles[i][3]);
            Point point3 = new Point(rectangles[i][0], rectangles[i][3]);
            Point point4 = new Point(rectangles[i][2], rectangles[i][1]);
            map.put(point1, map.getOrDefault(point1, 0) + 1);
            map.put(point2, map.getOrDefault(point2, 0) + 1);
            map.put(point3, map.getOrDefault(point3, 0) + 1);
            map.put(point4, map.getOrDefault(point4, 0) + 1);
            mini = Math.min(mini, rectangles[i][0]);
            minj = Math.min(minj, rectangles[i][1]);
            maxi = Math.max(maxi, rectangles[i][2]);
            maxj = Math.max(maxj, rectangles[i][3]);
        }

        int maxArea = Math.abs(maxi - mini) * Math.abs(maxj - minj);
        Point point1 = new Point(maxi, maxj);
        Point point2 = new Point(maxi, minj);
        Point point3 = new Point(mini, maxj);
        Point point4 = new Point(mini, minj);
        if(area != maxArea || map.getOrDefault(point1, 0) != 1 ||
        map.getOrDefault(point2, 0) != 1 || map.getOrDefault(point3, 0) != 1 ||
        map.getOrDefault(point4, 0) != 1) return false;

        map.remove(point1);
        map.remove(point2);
        map.remove(point3);
        map.remove(point4);

        for(int value : map.values()) {
            if(value != 2 && value != 4) {
                return false;
            }
        }
        return true;
    }

    public class Point{

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;

        public int hashCode() {
            return x + y;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point point = (Point) obj;
                return this.x == point.x && this.y == point.y;
            }
            return false;
        }
    }
}
