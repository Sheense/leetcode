package com.company.math;

public class 绝对值表达式的最大值 {

    public static void main(String[] args) {
        绝对值表达式的最大值 s = new 绝对值表达式的最大值();
        System.out.println(s.maxAbsValExpr(new int[]{1,-2},new int[]{8,8}));
    }

    //去绝对值
    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        if(arr1.length==2) {
            return 1+Math.abs(arr1[0]-arr1[1]) + Math.abs(arr2[0]-arr2[1]);
        }
        int[][] map = {{1, 1, 1}, {1, 1, -1}, {1, -1, 1}, {-1, 1, 1}, {1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, -1, -1}};

        int[] max = new int[8];
        for(int i=0;i<8;i++) {
            for(int j=0;j<arr1.length;j++) {
                max[i] = Math.max(max[i], map[i][0]*arr1[j]+ map[i][1]*arr2[j]+ map[i][2]*j);
            }
        }

        int res = 0;
        for(int i=0;i<8;i++) {
            for(int j=0;j<arr1.length;j++) {
                res = Math.max(res, max[i] + (map[i][0]*arr1[j]+ map[i][1]*arr2[j]+ map[i][2]*j));
            }
        }
        return res;
    }
}
