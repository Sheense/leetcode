package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

public class 螺旋矩阵III {

    public static void main(String[] args) {
        螺旋矩阵III s = new 螺旋矩阵III();
        ArrayUtils.print2(s.spiralMatrixIII(1,4,0,0));
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int length = R*C;
        int[][] res = new int[length][2];
        int index = 1;
        int row = 2;
        int x = r0;
        int y = c0+1;
        res[0][0] = r0;
        res[0][1] = c0;
        while(index<length) {
            for(int i=0;i<row&&index<length;i++) {
                if(i!=0) x ++;
                if(y>=0&&y<C&&x>=0&&x<R) {
                    res[index][0] = x;
                    res[index][1] = y;
                    index++;
                }
            }
            y--;
            for(int i=0;i<row&&index<length;i++) {
                if(i!=0) y --;
                if(y>=0&&y<C&&x>=0&&x<R) {
                    res[index][0] = x;
                    res[index][1] = y;
                    index++;
                }
            }
            x--;
            for(int i=0;i<row&&index<length;i++) {
                if(i!=0) x --;
                if(y>=0&&y<C&&x>=0&&x<R) {
                    res[index][0] = x;
                    res[index][1] = y;
                    index++;
                }
            }
            y++;
            for(int i=0;i<row&&index<length;i++) {
                if(i!=0) y ++;
                if(y>=0&&y<C&&x>=0&&x<R) {
                    res[index][0] = x;
                    res[index][1] = y;
                    index++;
                }
            }
            y++;
            row+=2;
        }
        return res;
    }
}
