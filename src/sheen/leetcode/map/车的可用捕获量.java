package sheen.leetcode.map;

public class 车的可用捕获量 {
    public static void main(String[] args) {


    }
    public int numRookCaptures(char[][] board) {
        int i = 0;
        int j = 0;
        int res = 0;
        for(int index=0;index<board.length;index++) {
            String s = String.valueOf(board[index]);
            if(s.contains("R")) {
                i = index;
                j = s.indexOf("R");
            }
        }
        int left = j-1;
        int right = j+1;
        while(left>=0) {
            if(board[i][left]=='B') break;
            if(board[i][left]=='p') {
                res++;
                break;
            }
            left--;
        }
        while(right<board[i].length) {
            if(board[i][right]=='B') break;
            if(board[i][right]=='p') {
                res++;
                break;
            }
            right++;
        }
        int up = i-1;
        int down = i+1;
        while(up>=0) {
            if(board[up][j]=='B') break;
            if(board[up][j]=='p') {
                res++;
                break;
            }
            up--;
        }
        while(down<board.length) {
            if(board[down][j]=='B') break;
            if(board[down][j]=='p') {
                res++;
                break;
            }
            down++;
        }
        return res;
    }
}
