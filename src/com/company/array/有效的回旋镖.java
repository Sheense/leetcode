package com.company.array;

/**
 * @Classname 有效的回旋镖
 * @Date 2022/6/8 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 有效的回旋镖 {
    public boolean isBoomerang(int[][] points) {
        if((points[0][0] == points[1][0] && points[0][1] == points[1][1]) ||
                (points[2][0] == points[1][0] && points[2][1] == points[1][1]) ||
                (points[2][0] == points[0][0] && points[2][1] == points[0][1])) {
            return false;
        }
        String a = x(points[0], points[1]);
        String b = x(points[1], points[2]);
        return !a.equals(b);
    }

    public String x(int[] p1, int[] p2) {
        if(p1[0] == p2[0]) {
            return "";
        }
        if(p1[1] == p2[1]) {
            return "0";
        }

        double b = (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
        return String.valueOf(b);
    }
}
