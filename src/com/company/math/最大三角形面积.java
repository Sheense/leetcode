package com.company.math;

/**
 * @Classname 最大三角形面积
 * @Date 2022/5/15 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大三角形面积 {
    public static void main(String[] args) {
        最大三角形面积 s = new 最大三角形面积();
        System.out.println(s.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}));
    }
    public double largestTriangleArea(int[][] points) {
        double res = -1;
        for(int i = 0; i < points.length - 2; i++) {
            for(int j = i + 1; j < points.length - 1; j++) {
                for(int z = j + 1; z < points.length; z++) {
                    res = Math.max(res, triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[z][0], points[z][1]));
                }
            }
        }
        return res;
    }
    public double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }
}
