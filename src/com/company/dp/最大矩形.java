package com.company.dp;

import com.company.util.ArrayUtils;

public class 最大矩形 {

    public static void main(String[] args) {
        最大矩形 a = new 最大矩形();
        /*char [][] matrix = new char[][]{{'1','0','1','0','0'}
                                       ,{'1','0','1','1','1'}
                                       ,{'1','1','1','1','1'}
                                       ,{'1','0','0','1','0'}};*/
        char[][] matrix = new char[][]{{'1','1'}};
        System.out.print(a.amaximalRectangle(matrix));
    }
    public int  amaximalRectangle (char[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        int[][] rDp = new int[matrix.length][matrix[0].length];
        int[][] cDp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0') rDp[i][j] = 0;
                else rDp[i][j] = j-1>=0? 1 + rDp[i][j-1] : 1;
            }
        }
        ArrayUtils.print2(rDp);
        for(int j=0;j<matrix[0].length;j++) {
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][j]=='0') cDp[i][j] = 0;
                else cDp[i][j] = i-1>=0? 1 + cDp[i-1][j]:1;
            }
        }
        ArrayUtils.print2(cDp);
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(rDp[i][j]!=0) {
                    int index = 0;
                    int min = rDp[i][j];
                    while(index!=cDp[i][j]) {
                        min = min>rDp[i-index][j]?rDp[i-index][j]:min;
                        max = max<min*(index+1)?min*(index+1):max;
                        index++;
                    }
                }
            }
        }
        return max;
    }
}
