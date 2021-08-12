package com.company.array;

/**
 * @Classname 检查操作是否合法
 * @Date 2021/8/7 11:15 下午
 * @Created by sheen
 * @Description TODO
 */
public class 检查操作是否合法 {

    public static void main(String[] args) {
        char[][] chars = {{'B', 'B', '.', '.', 'B', 'W', 'W', '.'},
                          {'.', 'W', 'W', '.', 'B', 'W', 'B', 'B'},
                          {'.', 'W', 'B', 'B', 'W', '.', 'W', '.'},
                          {'B', '.', '.', 'B', 'W', 'W', 'W', '.'},
                          {'W', 'W', 'W', 'B', 'W', '.', 'B', 'W'},
                          {'.', '.', '.', 'W', '.', 'W', '.', 'B'},
                          {'B', 'B', 'W', 'B', 'B', 'W', 'W', 'B'},
                          {'W', '.', 'W', 'W', '.', 'B', '.', 'W'}};
        检查操作是否合法  s = new 检查操作是否合法();
        System.out.println(s.checkMove(chars, 2, 5, 'W'));
    }

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        char other = color == 'W' ? 'B' : 'W';
        int index = cMove - 1;
        while (index > 0 && board[rMove][index] == other) {
            index--;
        }
        if(index >= 0 && cMove - index >=2 && board[rMove][index] == color) {
            System.out.println(1);
            return true;
        }

        index = cMove + 1;
        while (index < board[rMove].length-1 && board[rMove][index] == other) {
            index++;
        }
        if(index < board[rMove].length  && index - cMove >=2 &&board[rMove][index] == color) {
            System.out.println(2);
            return true;
        }

        index = rMove - 1;
        while (index > 0 && board[index][cMove] == other) {
            index--;
        }
        if(index >= 0 && rMove - index >= 2 && board[index][cMove] == color) {
            System.out.println(3);
            return true;
        }

        index = rMove + 1;
        while (index < board.length-1 && board[index][cMove] == other) {
            index++;
        }
        if(index< board.length && index - rMove >= 2 && board[index][cMove] == color) {
            System.out.println(4);
            return true;
        }



        int i = rMove - 1;
        int j = cMove - 1;
        while (i > 0 && j > 0 && board[i][j] == other) {
            i --;
            j --;
        }
        if(cMove - j >= 2 && board[i][j] == color) {
            System.out.println(5);
            return true;

        }


        i = rMove + 1;
        j = cMove + 1;
        while (i < board.length -1 && j < board[rMove].length - 1 && board[i][j] == other) {
            i++;
            j++;
        }
        if(j - cMove >=2 && board[i][j] == color) {
            System.out.println(6);
            return true;
        }

        i = rMove + 1;
        j = cMove - 1;
        while (i < board.length - 1 && j > 0 && board[i][j] == other) {
            i ++;
            j --;
        }
        if(cMove - j >=2 && board[i][j] == color) {
            System.out.println(7);
            return true;
        }

        i = rMove - 1;
        j = cMove + 1;
        while (i > 0 && j < board[rMove].length -1 && board[i][j] == other) {
            i --;
            j ++;
        }
        if(j - cMove >=2 && board[i][j] == color) {
            System.out.println(8);
            return true;
        }

        return false;
    }
}
