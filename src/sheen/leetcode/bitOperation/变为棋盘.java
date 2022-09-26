package sheen.leetcode.bitOperation;

/**
 * @Classname 变为棋盘
 * @Date 2022/8/23 12:40 上午
 * @Created by sheen
 * @Description TODO
 */
public class 变为棋盘 {
    public static void main(String[] args) {
        变为棋盘 s = new 变为棋盘();
        System.out.println(s.movesToChessboard(new int[][]
                {
        {0,0,1,1,1,0,1},
        {0,0,1,1,1,0,1},
        {0,0,1,1,1,0,1},
        {1,1,0,0,0,1,1},
        {1,1,0,0,0,1,1},
        {0,0,1,1,1,0,1},
        {1,1,0,0,0,1,1}}));
    }
    public int movesToChessboard(int[][] board) {
        int[] rowBit = getBit(board, 0);
        int[] colBit = getBit(board, 1);
        int n = board.length;
        if(!checkChessboard(rowBit, colBit, n)) {
            return -1;
        }
        int res = 0;
        if(n % 2 == 0) {
            int mod = rowBit[0];
            int ou = 0;
            for(int i = 0; i < rowBit.length; i++) {
                if(rowBit[i] == mod && i % 2 == 0) {
                    ou++;
                }
            }
            res += Math.min(ou, n / 2 - ou);

            mod = colBit[0];
            ou = 0;
            for(int i = 0; i < colBit.length; i++) {
                if(colBit[i] == mod && i % 2 == 0) {
                    ou++;
                }
            }
            res += Math.min(ou, n / 2 - ou);
        }else {
            int oneCount = 0;
            int zeroCount = 0;
            for(int i = 0; i < rowBit.length; i++) {
                if(getRowCount(rowBit[i], n, 0) > getRowCount(rowBit[i], n, 1)) {
                    zeroCount++;
                }else {
                    oneCount++;
                }
            }

            if(zeroCount > oneCount) {
                int ou = 0;
                for(int i = 0; i < rowBit.length; i++) {
                    if(i % 2 == 0 && getRowCount(rowBit[i], n, 0) > getRowCount(rowBit[i], n, 1)) {
                        ou++;
                    }
                }
                res += n / 2 + 1 - ou;

                ou = 0;
                for(int i = 0; i < colBit.length; i++) {
                    if(i % 2 == 0 && getRowCount(colBit[i], n, 0) > getRowCount(colBit[i], n, 1)) {
                        ou++;
                    }
                }
                res += n / 2 + 1 - ou;
            }else {
                int ou = 0;
                for(int i = 0; i < rowBit.length; i++) {
                    if(i % 2 == 0 && getRowCount(rowBit[i], n, 0) < getRowCount(rowBit[i], n, 1)) {
                        ou++;
                    }
                }
                res += n / 2 + 1 - ou;

                ou = 0;
                for(int i = 0; i < colBit.length; i++) {
                    if(i % 2 == 0 && getRowCount(colBit[i], n, 0) < getRowCount(colBit[i], n, 1)) {
                        ou++;
                    }
                }
                res += n / 2 + 1 - ou;
            }
        }

        return res;
    }

    public int getRowCount(int v, int n, int target) {
        int res = 0;
        while (n -- != 0) {
            if(v % 2 == target) {
                res++;
            }
            v >>= 1;
        }
        return res;
    }

    public boolean checkChessboard(int[] rowBit, int[] colBit, int n) {
        if(!checkRow(rowBit[0], colBit[0], n)) {
            return false;
        }
        return check(new int[]{rowBit[0], reserve(rowBit[0], n)}, rowBit, n) && check(new int[]{colBit[0], reserve(colBit[0], n)}, colBit, n);
    }

    public boolean checkRow(int a, int b, int n) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        while (n-- != 0) {
            if((a & 1) == 0) {
                aCount++;
            }else {
                bCount++;
            }
            if((b & 1) == 0) {
                cCount ++;
            }else {
                dCount ++;
            }
            a >>= 1;
            b >>= 1;
        }
        if(n % 2 == 0 && (aCount != bCount || cCount != dCount) ) {
            return false;
        }
        if(n % 2 == 1 && (Math.abs(aCount - bCount) != 1 || Math.abs(cCount - dCount) != 1) ) {
            return false;
        }
        return true;
    }

    public int reserve(int a, int n) {
        int res = 0;
        int i = 0;
        while (n-- != 0) {
            if((a & 1) == 0) {
                res |= (1 << i);
            }
            i++;
            a >>= 1;
        }

        return res;
    }

    public boolean check(int[] mod, int[] target, int n) {
        int aCount = 0;
        int bCount = 0;
        for(int i = 0; i < target.length; i++) {
            if(target[i] == mod[0]) {
                aCount++;
            }else if(target[i] == mod[1]) {
                bCount++;
            }else {
                return false;
            }
        }
        if(n % 2 == 0 && aCount != bCount) {
            return false;
        }
        if(n % 2 == 1 && Math.abs(aCount - bCount) != 1) {
            return false;
        }
        return true;
    }

    public int[] getBit(int[][] board, int type) {
        int[] res = new int[board.length];
        if(type == 0) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    res[i] <<= 1;
                    res[i] |= board[i][j];
                }
            }
        }else {
            for(int i = 0; i < board[0].length; i++) {
                for(int j = 0; j < board.length; j++) {
                    res[i] <<= 1;
                    res[i] |= board[j][i];
                }
            }
        }
        return res;
    }
}
