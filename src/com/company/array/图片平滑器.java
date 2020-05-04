package com.company.array;

public class 图片平滑器 {

    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        for(int i=0;i<M.length;i++) {
            for(int j=0;j<M[i].length;j++) {
                int num = M[i][j];
                int count = 1;
                if(j-1>=0) {
                    num+= M[i][j-1];
                    count++;
                }
                if(j+1<M[i].length) {
                    num += M[i][j+1];
                    count++;
                }

                if(i-1>=0) {
                    num += M[i-1][j];
                    count++;
                    if(j-1>=0) {
                        num += M[i-1][j-1];
                        count++;
                    }
                    if(j+1<M[i].length) {
                        num += M[i-1][j+1];
                        count++;
                    }
                }
                if(i+1<M.length) {
                    num += M[i+1][j];
                    count++;
                    if(j-1>=0) {
                        num += M[i+1][j-1];
                        count++;
                    }
                    if(j+1<M[i].length) {
                        num += M[i+1][j+1];
                        count++;
                    }
                }
                num /= count;
                res[i][j] = num;
            }
        }
        return res;
    }
}
