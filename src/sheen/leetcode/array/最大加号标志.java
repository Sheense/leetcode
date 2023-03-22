package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 最大加号标志
 * @Date 2022/11/9 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大加号标志 {
    public static void main(String[] args) {
        最大加号标志 s = new 最大加号标志();
        System.out.println(s.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
    }
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];
        int[][] map = new int[n][n];
        for(int i = 0; i < mines.length; i++) {
            map[mines[i][0]][mines[i][1]] = 1;
        }
        for(int i = 0; i < n; i++) {
            for(int j = n - 1; j >= 0; j--) {
                if(map[i][j] == 0) {
                    right[i][j] = j == n - 1 ? 1 : right[i][j + 1] + 1;
                }
                if(map[j][i] == 0) {
                    down[j][i]  = j == n - 1 ? 1 :  down[j + 1][i] + 1;
                }
            }
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0) {
                    left[i][j] = j == 0 ? 1 :  left[i][j - 1] + 1;
                }

                if(map[j][i] == 0) {
                    up[j][i] = j == 0 ? 1 : up[j - 1][i] + 1;
                }
            }
        }
        /*System.out.println("left:");
        ArrayUtils.print2(left);
        System.out.println("right:");
        ArrayUtils.print2(right);
        System.out.println("up:");
        ArrayUtils.print2(up);
        System.out.println("down:");
        ArrayUtils.print2(down);*/

        int max = n % 2 == 1 ? n / 2 : n / 2 - 1;
        for(int i = max; i >= 1; i--) {
            for(int j = 0; j < n; j++) {
                for(int z = 0; z < n; z++) {
                    if(left[j][z] > i && right[j][z] > i && up[j][z] > i && down[j][z] > i) {
                        return i + 1;
                    }
                }
            }
        }

        return mines.length < n * n ? 1 : 0;
    }
}
