package com.company.array;

public class 统计全1子矩形 {

    public static void main(String[] args) {
        统计全1子矩形 s = new 统计全1子矩形();
        System.out.println(s.numSubmat(new int [][]{
                            {1,0,1},
                            {1,1,0},
                            {1,1,0}
        }));
    }
    public int numSubmat(int[][] mat) {
        int [][] row = new int[mat.length][mat[0].length];
        int res = 0;
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[i].length;j++) {
                if(mat[i][j]==1) {
                    row[i][j] = j==0?1:row[i][j-1] + 1;
                }
                res += row[i][j];
            }
        }
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[i].length;j++) {
                if(row[i][j]==0) continue;
                int index = i+1;
                int min = row[i][j];

                while(index<mat.length&&row[index][j]!=0) {
                    if(row[index][j]<=min) {
                        min = row[index][j];
                    }
                    res+=min-1;
                    res++;
                    index++;
                }
            }
        }
        return res;
    }
}
