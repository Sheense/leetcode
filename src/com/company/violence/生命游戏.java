package com.company.violence;

import com.company.util.ArrayUtils;

public class 生命游戏 {
    public static void main(String[] args) {
        生命游戏 s = new 生命游戏();
        int [][] a = {
                            {0,1,0},
                            {0,0,1},
                            {1,1,1},
                            {0,0,0}
        };
        s.gameOfLife(a);
        ArrayUtils.print2(a);
    }

    public void gameOfLife(int[][] board) {
        int [][] map = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                int live = 0;
                if(i-1>=0) {
                    if(j-1>=0) {
                        if(board[i-1][j-1]==1) live++;
                    }
                    if(j+1<board[i].length) {
                        if(board[i-1][j+1]==1) live++;
                    }
                    if(board[i-1][j]==1) live++;
                }
                if(i+1<board.length) {
                    if(j-1>=0) {
                        if(board[i+1][j-1]==1) live++;
                    }
                    if(j+1<board[i].length) {
                        if(board[i+1][j+1]==1) live++;
                    }
                    if(board[i+1][j]==1) live++;
                }
                if(j-1>=0) {
                    if(board[i][j-1]==1) live++;
                }
                if(j+1<board[i].length) {
                    if(board[i][j+1]==1) live++;
                }

                if (board[i][j] == 0) {
                   if(live==3) map[i][j] = 1;
                } else{
                    if(live==2||live==3) map[i][j] = 1;
                }
            }
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                board[i][j] = map[i][j];
            }
        }
    }
}
