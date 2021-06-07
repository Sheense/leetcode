package com.company.array;

public class 判断矩阵经轮转后是否一致 {
    public boolean findRotation(int[][] mat, int[][] target) {
        if(mat.length == 0) return true;
        if(mat.length == 1) {
            return mat[0][0] == target[0][0];
        }
        int[] arr = new int[target.length * target[0].length];
        int index = 0;
        for(int i = 0;i<target.length;i++) {
            for(int j = 0;j<target[i].length;j++) {
                arr[index ++] = target[i][j];
            }
        }
        boolean flag = true;
        index = 0;
        for(int i= 0;i<mat.length;i++) {
            for(int j=0;j<mat[i].length;j++) {
                if(mat[i][j] != arr[index++]) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }
        if (flag) return true;
        flag = true;
        index = 0;
        for(int i = 0; i<mat[0].length; i++) {
            for(int j = mat.length-1;j>=0;j--) {
                if(mat[j][i] != arr[index++]) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }
        if (flag) return true;
        flag = true;
        index = 0;
        for(int i = mat.length-1;i>=0;i--) {
            for(int j = mat[0].length-1;j>=0;j--) {
                if(mat[i][j] != arr[index++]) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }
        if (flag) return true;
        flag = true;
        index = 0;
        for(int i = mat[0].length-1;i>=0;i--) {
            for(int j = 0; j < mat.length; j++) {
                if(mat[j][i] != arr[index++]) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }
        return flag;
    }
}
