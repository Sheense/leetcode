package sheen.leetcode.array;

/**
 * @Classname 有效的井字游戏
 * @Date 2021/12/9 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 有效的井字游戏 {
    public static void main(String[] args) {
        有效的井字游戏 s = new 有效的井字游戏();
        System.out.println(s.validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
    }
    public boolean validTicTacToe(String[] board) {
        int XNum = 0;
        int ONum = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'X') {
                    XNum ++;
                }
                if(board[i].charAt(j) == 'O') {
                    ONum ++;
                }
            }
        }
        if(XNum < ONum || XNum > ONum + 1) {
            return false;
        }
        int XWin = 0;
        int OWin = 0;
        for(int i = 0; i < 3; i ++) {
            char c = board[i].charAt(0);
            boolean flag = true;
            for(int j = 0; j < board[i].length(); j++) {
                if(c != board[i].charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if(c == 'X') {
                    XWin ++;
                }
                if(c == 'O') {
                    OWin ++;
                }
            }

            c = board[0].charAt(i);
            flag = true;
            for(int j = 0; j < 3; j++) {
                if(c != board[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if(c == 'X') {
                    XWin ++;
                }
                if(c == 'O') {
                    OWin ++;
                }
            }
        }

        char a = board[0].charAt(0);
        char b = board[1].charAt(1);
        char c = board[2].charAt(2);
        if(a == b && b == c) {
            if(a == 'X') {
                XWin ++;
            }
            if(a == 'O') {
                OWin++;
            }
        }

        a = board[0].charAt(2);
        b = board[1].charAt(1);
        c = board[2].charAt(0);
        if(a == b && b == c) {
            if(a == 'X') {
                XWin ++;
            }
            if(a == 'O') {
                OWin++;
            }
        }

        if(XWin > 0 && OWin > 0) {
            return false;
        }
        if(XWin > 0 && OWin == 0 && XNum == ONum) {
            return false;
        }
        if(OWin > 0 && XWin == 0 && XNum > ONum) {
            return false;
        }

        return true;
    }
}
