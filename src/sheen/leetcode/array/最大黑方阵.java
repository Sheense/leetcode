package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 最大黑方阵
 * @Date 2023/5/8 3:32 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最大黑方阵 {
    public static void main(String[] args) {
        最大黑方阵 s = new 最大黑方阵();
        //ArrayUtils.print(s.findSquare(new int[][]{{1, 0, 1}, {0, 0, 1}, {0, 0, 1}}));
        ArrayUtils.print(s.findSquare(new int[][]{{0,1,1}, {1, 0, 1}, {1, 1, 0}}));
    }
    public int[] findSquare(int[][] matrix) {
        int[][] row = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    if(j == 0) {
                        row[i][j] = 1;
                    }else {
                        row[i][j] = row[i][j - 1] + 1;
                    }
                }else {
                    if(j != 0) {
                        row[i][j] = row[i][j - 1];
                    }
                }
            }
        }

        int[][] col = new int[matrix[0].length][matrix.length];
        for(int j = 0; j < matrix[0].length; j++) {
            for(int i = 0; i < matrix.length; i++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) {
                        col[i][j] = 1;
                    }else {
                        col[i][j] = col[i - 1][j] + 1;
                    }
                }else {
                    if(i != 0) {
                        col[i][j] = col[i - 1][j];
                    }
                }
            }
        }
        int maxLen = 0;
        int r = 0;
        int c = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                for(int start = 0; start <= j; start++) {
                    int len = j - start + 1;
                    if(start == 0) {
                        if(len == row[i][j]) {
                            int nextI = i + j - start;
                            if(nextI < matrix.length && row[nextI][j] == len) {
                                if(i == 0) {
                                    if(col[nextI][start] == len && col[nextI][j] == len) {
                                        if(len > maxLen) {
                                            maxLen = len;
                                            r = i;
                                            c = start;
                                        }
                                    }
                                }else {
                                    if(col[nextI][start] - col[i - 1][start] == len && col[nextI][j] - col[i - 1][j] == len) {
                                        if(len > maxLen) {
                                            maxLen = len;
                                            r = i;
                                            c = start;
                                        }
                                    }
                                }
                            }
                        }
                    }else {
                        if(len == row[i][j] - row[i][start - 1]) {
                            int nextI = i + j - start;
                            if(nextI < matrix.length && row[nextI][j] - row[nextI][start - 1] == len) {
                                if(i == 0) {
                                    if(col[nextI][start] == len && col[nextI][j] == len) {
                                        if(len > maxLen) {
                                            maxLen = len;
                                            r = i;
                                            c = start;
                                        }
                                    }
                                }else {
                                    if(col[nextI][start] - col[i - 1][start] == len && col[nextI][j] - col[i - 1][j] == len) {
                                        if(len > maxLen) {
                                            maxLen = len;
                                            r = i;
                                            c = start;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(maxLen == 0) {
            return new int[]{};
        }
        return new int[]{r, c, maxLen};
    }
}
