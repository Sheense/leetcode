package sheen.leetcode.array;


public class 最大正方形 {

    public static void main(String[] args) {
        最大正方形 s = new 最大正方形();
        char[][] map = {
                            {'1','0','1' ,'0' ,'0'},
                            {'1' ,'0' ,'1' ,'1' ,'1'},
                            {'1' ,'1' ,'1' ,'1' ,'1'},
                            {'1', '0' ,'0' ,'1' ,'0'}
        };
        System.out.println(s.maximalSquare(map));
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int max = 0;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                if(j!=0){
                    if(matrix[i][j]=='1') {
                        matrix[i][j] = (char)(1+matrix[i][j-1]);
                    }else {
                        matrix[i][j] = 0;
                    }
                }else {
                    if(matrix[i][j]=='1') {
                        matrix[i][j]=1;
                    }else {
                        matrix[i][j] =0;
                    }
                }
                if(matrix[i][j]>=2) {
                    int time = 1;
                    int row = matrix[i][j];
                    while(i-time>=0&&time!=row) {
                        if(matrix[i-time][j]<row) {
                            if(time+1>=matrix[i-time][j]){
                                row = matrix[i-time][j];
                                time++;
                                break;
                            }else {
                                row = matrix[i-time][j];
                            }
                        }
                        time++;
                    }
                    if(time==row&&max<row*row) {
                        max = row*row;
                    }
                }else if(matrix[i][j]==1) {
                    if(max<matrix[i][j]) max = matrix[i][j];
                }
            }
        }
        return max;
    }
}
