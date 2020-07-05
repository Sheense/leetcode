package com.company.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 有效的数独 {
    public static void main(String[] args) {
        有效的数独 s = new 有效的数独();
        System.out.println(s.isValidSudoku(new char[][] {
                            {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','0','6','.'}
        }));
    }

    public boolean isValidSudoku(char[][] board) {
        if(board.length==0) return true;
        List<Set<Character>> row = new ArrayList<>();
        for(int i=0;i<board.length;i++) row.add(new HashSet<>());
        List<Set<Character>> column = new ArrayList<>();
        for(int i=0;i<board[0].length;i++) column.add(new HashSet<>());
        List<Set<Character>>list = new ArrayList<>();
        for(int i=0;i<board[0].length;i=i+3) list.add(new HashSet<>());

        for(int i=0;i<board.length;i++) {
            if(i>=3&&i%3==0) {
                list = new ArrayList<>();
                for(int j=0;j<board[0].length;j=j+3) list.add(new HashSet<>());
            }
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='.') continue;
                Set<Character> s1 = row.get(i);
                Set<Character> s2 = column.get(j);
                Set<Character> s3 = list.get(j/3);
                if(s1.contains(board[i][j])||s2.contains(board[i][j])||s3.contains(board[i][j])) {
                    return false;
                }
                s1.add(board[i][j]);
                s2.add(board[i][j]);
                s3.add(board[i][j]);
            }
        }
        return true;
    }
}
