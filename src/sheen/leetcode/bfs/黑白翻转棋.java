package sheen.leetcode.bfs;

import java.util.*;

/**
 * @Classname 黑白翻转棋
 * @Date 2023/6/21 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 黑白翻转棋 {

    public static void main(String[] args) {
        黑白翻转棋 s = new 黑白翻转棋();
        System.out.println(s.flipChess(new String[]{".......",".......",".......","X......",".O.....","..O....","....OOX"}));
    }
    public int flipChess(String[] chessboard) {
        int res = 0;
        for(int i = 0; i < chessboard.length; i++) {
            for(int j = 0; j < chessboard[i].length(); j++) {
                if(chessboard[i].charAt(j) == '.') {
                    res = Math.max(res, getCount(i, j, chessboard));
                }
            }
        }
        return res;
    }

    public int getCount(int i, int j, String[] chessboard) {
        int ans = 0;
        int row = chessboard.length;
        int col = chessboard[0].length();
        char[][] copy = new char[row][col];
        for(int q = 0; q < chessboard.length; q++) {
            copy[q] = chessboard[q].toCharArray();
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        copy[i][j] = 'X';
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int[] item = queue.poll();
                for(int q = 0; q < 8; q++) {
                    List<int[]> res = getRun(item[0], item[1], q, copy);
                    if(res != null) {
                        ans += res.size();
                        for(int[] v : res) {
                            queue.offer(v);
                            copy[v[0]][v[1]] = 'X';
                        }
                    }
                }
            }
        }
        return ans;
    }

    public List<int[]> getRun(int i, int j, int foot, char[][] copy) {
        int row = copy.length;
        int col = copy[0].length;
        List<int[]> res = new ArrayList<>();
        switch (foot) {
            case 0:{
                i--;
                while (i >= 0 && copy[i][j] == 'O') {
                    res.add(new int[]{i, j});
                    i--;
                }
                if(i < 0 || copy[i][j] != 'X') {
                    return null;
                }
                break;
            }
            case 1:{
                i++;
                while (i < row && copy[i][j] == 'O') {
                    res.add(new int[]{i, j});
                    i++;
                }
                if(i >= row || copy[i][j] != 'X') {
                    return null;
                }
                break;
            }
            case 2:{
                j--;
                while (j >= 0 && copy[i][j] == 'O') {
                    res.add(new int[]{i, j});
                    j--;
                }
                if(j < 0 || copy[i][j] != 'X') {
                    return null;
                }
                break;
            }
            case 3:{
                j++;
                while (j < col && copy[i][j] == 'O') {
                    res.add(new int[]{i, j});
                    j++;
                }
                if(j >= col || copy[i][j] != 'X') {
                    return null;
                }
                break;
            }

            case 4:{
                i++;
                j++;
                while (i < row && j < col && copy[i][j] == 'O') {
                    res.add(new int[]{i, j});
                    i++;
                    j++;
                }
                if (i >= row || j >= col || copy[i][j] != 'X') {
                    return null;
                }
                break;
            }
            case 5:{
                i++;
                j--;
                while (i < row && j >= 0 && copy[i][j] == 'O') {
                    res.add(new int[]{i, j});
                    i++;
                    j--;
                }
                if(i >= row || j < 0 || copy[i][j] != 'X') {
                    return null;
                }
                break;
            }
            case 6:{
                i--;
                j--;
                while (i >= 0 && j >= 0 && copy[i][j] == 'O') {
                    res.add(new int[]{i, j});
                    i--;
                    j--;
                }
                if(i < 0 || j < 0 || copy[i][j] != 'X') {
                    return null;
                }
                break;
            }
            case 7:{
                i--;
                j++;
                while (i >= 0 && j < col && copy[i][j] == 'O') {
                    res.add(new int[]{i, j});
                    i--;
                    j++;
                }
                if(i < 0 || j >= col || copy[i][j] != 'X') {
                    return null;
                }
                break;
            }
        }
        return res;
    }



}
