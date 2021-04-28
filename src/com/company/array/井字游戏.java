package com.company.array;

public class 井字游戏 {
    public String tictactoe(String[] board) {
        int N = board.length;
        String res = "Draw";
        for(int i=0;i<N;i++) {
            char first = board[i].charAt(0);
            for(int j=0;j<N;j++) {
                if(board[i].charAt(j) == ' ' || board[i].charAt(j) != first) {
                    if(board[i].charAt(j) == ' '){
                        res = "Pending";
                    }
                    break;
                }
                if(j == N - 1) {
                    return String.valueOf(first);
                }
            }
        }

        for(int i=0;i<N;i++) {
            char first = board[0].charAt(i);
            for(int j=0;j<N;j++) {
                if(board[j].charAt(i) == ' ' || board[j].charAt(i) != first) {
                    break;
                }
                if(j == N - 1) {
                    return String.valueOf(first);
                }
            }
        }
        char first = board[0].charAt(0);
        for(int i=0;i<N;i++) {
            if(board[i].charAt(i) == ' ' || first != board[i].charAt(i)) {
                break;
            }
            if(i == N - 1){
                return String.valueOf(first);
            }
        }
        first = board[0].charAt(N-1);
        for(int i=0;i<N;i++) {
            if(board[i].charAt(N - 1 - i) == ' ' || first != board[i].charAt(N - 1 - i)) {
                break;
            }
            if(i == N - 1){
                return String.valueOf(first);
            }
        }
        return res;
    }


}
