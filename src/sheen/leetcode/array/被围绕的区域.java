package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class 被围绕的区域 {
    public static void main(String[] args) {
        被围绕的区域 s = new 被围绕的区域();
        char[][] c = new char[][]{
                            {'X','O','X','O','X','O'},
                            {'O','X','O','X','O','X'},
                            {'X','O','X','O','X','O'},
                            {'O','X','O','X','O','X'}
        };
        s.solve(c);
        ArrayUtils.print2(c);
    }

    public void solve(char[][] board) {
        if(board.length<=2) return;
        List<Integer> row = new ArrayList<>();
        List<Integer> column = new ArrayList<>();
        boolean[][] map = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j]=='O') {
                    row.add(i);
                    column.add(j);
                    map[i][j] = true;
                }
            }
        }

        for(int i=0;i<row.size();i++) {
            if(map[row.get(i)][column.get(i)]) {
                List<Integer> r = new ArrayList<>();
                List<Integer> c = new ArrayList<>();
                if(find(row.get(i), column.get(i),map,r,c)) {
                    for(int j=0;j<r.size();j++) {
                        board[r.get(j)][c.get(j)] = 'X';
                    }
                }
            }
        }
    }

    public boolean find(int i, int j,boolean[][]map,List<Integer> row, List<Integer> column) {
        row.add(i);
        column.add(j);
        map[i][j] = false;
        boolean res = true;
        if(i+1==map.length) {
            res = res&&false;
        }else if(map[i+1][j]==false){
            res = res&&true;
        }else {
            res=find(i+1,j,map,row,column)&&res;
        }


        if(j+1==map[0].length) {
            res = res&&false;
        }else if(map[i][j+1]==false){
            res = res&&true;
        }else {
            res = find(i,j+1,map,row,column)&&res;
        }

        if(i-1==-1) {
            res = res&&false;
        }else if(map[i-1][j]==false){
            res = res&&true;
        }else {
            res = find(i-1,j,map,row,column)&&res;
        }

        if(j-1==-1) {
            res = res&&false;
        }else if(map[i][j-1]==false){
            res = res&&true;
        }else {
            res = find(i,j-1,map,row,column)&&res;
        }
        return res;
    }

}
