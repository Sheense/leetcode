package sheen.leetcode.enums;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 网络信号最好的坐标
 * @Date 2022/11/2 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 网络信号最好的坐标 {
    public static void main(String[] args) {
        网络信号最好的坐标 s = new 网络信号最好的坐标();
        ArrayUtils.print(s.bestCoordinate(new int[][]{{42,0,0}}, 7));
    }
    public int[] bestCoordinate(int[][] towers, int radius) {
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        for(int i = 0; i < towers.length; i++) {
            xMax = Math.max(towers[i][0], xMax);
            yMax = Math.max(towers[i][1], yMax);
        }
        int[] res = null;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i <= xMax; i++) {
            for(int j = 0; j <= yMax; j++) {
                int num = 0;
                for(int z = 0; z < towers.length; z++) {
                    int d = getD(i, j ,towers[z]);
                    if(d <= radius * radius) {
                        num += (int) Math.floor(towers[z][2] / (1 + Math.sqrt(d)));
                    }
                }

                if(num > max) {
                    max = num;
                    res = new int[] {i, j};
                }
            }
        }
        return res;
    }

    public int getD(int x, int y, int[] towers) {

        return (towers[0] - x) * (towers[0] - x) + (towers[1] - y) * (towers[1] - y);
    }
}
