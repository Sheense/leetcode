package com.company.array;

public class 找到最近的有相同X或Y坐标的点 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = 0;
        int minIndex = -1;
        for(int i=0;i<points.length;i++) {
            if(points[i][0]==x||points[i][1]==y) {
                int abs = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if(minIndex == -1 || min>abs) {
                    minIndex = i;
                    min = abs;
                }
            }
        }
        return minIndex;
    }
}
