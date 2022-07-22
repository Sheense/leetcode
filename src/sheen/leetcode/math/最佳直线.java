package sheen.leetcode.math;

import sheen.leetcode.util.ArrayUtils;
//当x1,x2,x3,……,xn和y1,y2,y3,……,yn均不为0时，x1/y1=x2/y2=x3/y3=……=xn/yn即可得两向量平行。
//判断垂直：两向量点乘为0即可。即x1*y1+x2*y2+x3*y3+……xn*yn=0
public class 最佳直线 {
    public static void main(String[] args) {
        最佳直线 s = new 最佳直线();
        ArrayUtils.print(s.bestLine(new int[][]{{-3320,51525},{-2214,-4833},{2400,13565}}));
    }
    public int[] bestLine(int[][] points) {
        int[] res = new int[2];
        int len = 0;
        for(int i=0;i<points.length-2;i++) {
            for(int j=i+1;j<points.length-1;j++) {
                int count = 2;
                long dx1 = (long)points[j][0] - (long)points[i][0];
                long dy1 = (long)points[j][1] - (long)points[i][1];
                for(int z=j+1;z<points.length;z++) {
                    long dx2 = (long)points[z][0] - (long)points[i][0];
                    long dy2 = (long)points[z][1] - (long)points[i][1];
                    if(dx2*dy1 == dx1*dy2) {
                        count++;
                    }
                    if(count>len) {
                        len = count;
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return res;
    }
}
