package sheen.leetcode.array;

public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int x = 0;
        int y = matrix[0].length-1;
        while(y>=0&&x<matrix.length){
            if(matrix[x][y]>target){
                y--;
            }else if(matrix[x][y]<target) {
                x++;
            }else {
                return true;
            }
        }
        return false;
    }
}
