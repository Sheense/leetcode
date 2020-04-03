package com.company.bfs;

public class 单词搜索 {

    public static void main(String[] args) {
        单词搜索 s = new 单词搜索();
        char[][] board = {
                            {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}
        };
        System.out.println(s.exist(board, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        boolean map[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j] == word.charAt(0)) {
                   if(bfs(board, i,j,word,0, map)) return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(char[][] board, int i,int j,String word,int index,boolean[][] map) {
        map[i][j] = true;
        index++;
        if(index == word.length()) return true;
        if(i-1>=0&&!map[i-1][j]&&word.charAt(index)==board[i-1][j]) {
            if(bfs(board, i-1,j,word,index,map)) return true;
        }
        if(j-1>=0&&!map[i][j-1]&&word.charAt(index)==board[i][j-1]) {
            if(bfs(board, i,j-1,word,index,map)) return true;
        }
        if(j+1<board[i].length&&!map[i][j+1]&&word.charAt(index)==board[i][j+1]) {
            if(bfs(board, i,j+1,word,index,map)) return true;
        }
        if(i+1<board.length&&!map[i+1][j]&&word.charAt(index)==board[i+1][j]) {
            if(bfs(board, i+1,j,word,index,map)) return true;
        }
        map[i][j] = false;
        index--;
        return false;
    }



}
