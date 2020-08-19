package com.company.bfs;

import com.company.util.ArrayUtils;

import java.util.LinkedList;
import java.util.Queue;

public class 扫雷游戏 {
    public static void main(String[] args) {
        扫雷游戏 s = new 扫雷游戏();
        ArrayUtils.print2(s.updateBoard(new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        },new int[]{3,0}));
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        x.offer(click[0]);
        y.offer(click[1]);
        while(!x.isEmpty()) {
            int size = x.size();
            while(size--!=0) {
                int i = x.poll();
                int j = y.poll();
                int mNum = 0;
                int[] map = new int[8];
                if(i-1>=0) {
                    if(board[i-1][j]=='E') {
                        map[0] = -1;
                    }else if(board[i-1][j]=='M') {
                        mNum ++;
                    }
                    if(j-1>=0) {
                        if(board[i-1][j-1]=='E') {
                            map[1] = -1;
                        }else if(board[i-1][j-1]=='M') {
                            mNum ++;
                        }
                    }
                    if(j+1<board[0].length) {
                        if(board[i-1][j+1]=='E') {
                            map[2] = -1;
                        }else if(board[i-1][j+1]=='M') {
                            mNum ++;
                        }
                    }
                }
                if (i+1<board.length) {
                    if(board[i+1][j]=='E') {
                        map[3] = -1;
                    }else if(board[i+1][j]=='M') {
                        mNum ++;
                    }
                    if(j-1>=0) {
                        if(board[i+1][j-1]=='E') {
                            map[4] = -1;
                        }else if(board[i+1][j-1]=='M') {
                            mNum ++;
                        }
                    }
                    if(j+1<board[0].length) {
                        if(board[i+1][j+1]=='E') {
                            map[5] = -1;
                        }else if(board[i+1][j+1]=='M') {
                            mNum ++;
                        }
                    }
                }
                if(j-1>=0) {
                    if(board[i][j-1]=='E') {
                        map[6] = -1;
                    }else if(board[i][j-1]=='M') {
                        mNum ++;
                    }
                }
                if(j+1<board[0].length) {
                    if(board[i][j+1]=='E') {
                        map[7] = -1;
                    }else if(board[i][j+1]=='M') {
                        mNum ++;
                    }
                }
                if(mNum>0){
                    board[i][j] = (char)(mNum+'0');
                }else {
                    board[i][j] = 'B';
                    for(int z=0;z<8;z++) {
                        switch (z) {
                            case 0:{
                                if(map[z]==-1) {
                                    board[i-1][j] = 'B';
                                    x.offer(i-1);
                                    y.offer(j);
                                }
                                break;
                            }
                            case 1:{
                                if(map[z]==-1) {
                                    board[i-1][j-1] = 'B';
                                    x.offer(i-1);
                                    y.offer(j-1);
                                }
                                break;
                            }
                            case 2:{
                                if(map[z]==-1) {
                                    board[i-1][j+1] = 'B';
                                    x.offer(i-1);
                                    y.offer(j+1);
                                }
                                break;
                            }
                            case 3:{
                                if(map[z]==-1) {
                                    board[i+1][j] = 'B';
                                    x.offer(i+1);
                                    y.offer(j);
                                }
                                break;
                            }
                            case 4:{
                                if(map[z]==-1) {
                                    board[i+1][j-1] = 'B';
                                    x.offer(i+1);
                                    y.offer(j-1);
                                }
                                break;
                            }
                            case 5:{
                                if(map[z]==-1) {
                                    board[i+1][j+1] = 'B';
                                    x.offer(i+1);
                                    y.offer(j+1);
                                }
                                break;
                            }
                            case 6:{
                                if(map[z]==-1) {
                                    board[i][j-1] = 'B';
                                    x.offer(i);
                                    y.offer(j-1);
                                }
                                break;
                            }
                            case 7:{
                                if(map[z]==-1) {
                                    board[i][j+1] = 'B';
                                    x.offer(i);
                                    y.offer(j+1);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        return board;
    }

}
