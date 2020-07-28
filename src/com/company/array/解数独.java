package com.company.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 解数独 {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[10][10];
        boolean[][] column = new boolean[10][10];
        boolean[][] matrix = new boolean[10][10];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j]!='.') {
                    row[i][board[i][j]-'0'] = true;
                    column[j][board[i][j]-'0'] = true;
                    matrix[getMatrixNum(i,j)][board[i][j]-'0'] = true;
                }
            }
        }
        recall_j(row,column,matrix,board,0,0);
    }

    public int getMatrixNum(int i, int j) {
        return i/3 + (j/3) * 3;
    }

    public boolean recall_j(boolean[][] row,boolean[][] column, boolean[][]matrix,char[][] board, int i, int j) {
        if(i==board.length) {
            return true;
        }
        if(board[i][j]!='.') {
            if(j+1==board[i].length) {
                return recall_j(row,column,matrix,board,i+1,0);
            }else {
                return recall_j(row,column,matrix,board,i,j+1);
            }
        }else {
            for(int x=1;x<10;x++) {
                if(!row[i][x]&&!column[j][x]&&!matrix[getMatrixNum(i,j)][x]) {
                    board[i][j] = (char)(x+'0');
                    row[i][x] = true;
                    column[j][x] = true;
                    matrix[getMatrixNum(i,j)][x] = true;
                    boolean flag;
                    if(j+1==board[i].length) {
                        flag = recall_j(row,column,matrix,board,i+1,0);
                    }else {
                        flag = recall_j(row,column,matrix,board,i,j+1);
                    }
                    if(flag) return flag;
                    board[i][j] = '.';
                    row[i][x] = false;
                    column[j][x] = false;
                    matrix[getMatrixNum(i,j)][x] = false;
                }
            }
            return false;
        }
    }
}
