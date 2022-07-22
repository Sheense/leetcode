package sheen.leetcode.array;

import java.util.Arrays;

public class 重新排列后的最大子矩阵 {
    public static void main(String[] args) {
        重新排列后的最大子矩阵 s = new 重新排列后的最大子矩阵();
        System.out.println(s.largestSubmatrix(new int[][]{{0,0,1},{1,1,1},{1,0,1}}));
    }
    public int largestSubmatrix(int[][] matrix) {
        int flag [] = new int[matrix[0].length];
        int res = 0;
        for(int i=matrix.length-1;i>=0;i--) {
            int temp[] = new int[matrix[0].length];
            for(int j=0;j<matrix[i].length;j++) {
                if(matrix[i][j]==0) {
                    temp[j] = 0;
                }else {
                    temp[j] = flag[j] + 1;
                }
                flag[j] = temp[j];
            }
            int max = 0;
            Arrays.sort(temp);
            int index = temp.length-1;
            while(index>=0&&temp[index]!=0) {
                int t = temp[index];
                int start = index;
                while(index>=0&&t==temp[index]&&temp[index]!=0) {
                    index--;
                }
                max = Math.max((temp.length-1-index)*t, max);
            }
             res = Math.max(res, max);
        }
        return res;
    }
}
