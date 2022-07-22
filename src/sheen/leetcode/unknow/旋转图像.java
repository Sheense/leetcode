package sheen.leetcode.unknow;

import sheen.leetcode.util.ArrayUtils;

public class 旋转图像 {
    public static void main(String[] args) {
        旋转图像 s = new 旋转图像();
        int[][] matrix ={
                            {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}
        };
        s.rotate(matrix);
        ArrayUtils.print2(matrix);
    }

    public void rotate(int[][] matrix) {
        rotate(matrix,0,matrix.length-1);
    }

    public void rotate(int[][] matrix, int start,int end) {
        if(start>=end) return;
        int length = end - start;
        int time = end - start;
        int i = start;
        int j = start;
        while(time!=0) {
            int x = i;
            int y = j;
            int num = matrix[i][j];

            int next_x;
            int next_y;
            int step = end-y;
            next_y= end;
            next_x = x+(length-step);
            num = update(num, matrix, next_x,next_y);
            x = next_x;
            y = next_y;

            step = end - x;
            next_x = end;
            next_y = y - (length-step);
            num = update(num, matrix, next_x,next_y);
            x = next_x;
            y = next_y;

            step = start - y;
            next_y= start;
            next_x = x-(length+step);
            num = update(num, matrix, next_x,next_y);
            x = next_x;
            y = next_y;

            step = start - x;
            next_x = start;
            next_y = y+(length+step);
            matrix[next_x][next_y] = num;


            j++;
            time--;
        }
        rotate(matrix, start+1, end-1);
    }

    public int update(int num, int[][] matrix, int i, int j) {
        int item = matrix[i][j];
        matrix[i][j] = num;
        return item;
    }


}
