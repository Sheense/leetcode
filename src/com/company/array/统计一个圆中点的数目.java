package com.company.array;

public class 统计一个圆中点的数目 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int count = 0;
            for(int j=0;j<points.length;j++) {
                if (Math.pow((queries[i][0] - points[j][0]), 2) + Math.pow((queries[i][1] - points[j][1]), 2) <= Math.pow(queries[i][2], 2)) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
